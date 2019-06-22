package com.akhambir.services;

import com.akhambir.dao.MoneyTransferHistoryDao;
import com.akhambir.dao.UserDao;
import com.akhambir.model.MoneyTransfer;
import com.akhambir.model.User;
import com.akhambir.services.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MoneyTransferHistoryDao moneyTransferHistoryDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username)
                .map(this::toUserDetails)
                .orElseGet(org.springframework.security.core.userdetails.User.builder().disabled(true)::build);
    }

    private UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferAmount(Integer fromAccount, Integer toAccount, Double amount) {
        userDao.findByAccount(fromAccount)
                .map(u -> { u.setAmount(u.getAmount() - amount); return  u; })
                .map(userDao::save)
                .orElseThrow(() -> new AccountNotFoundException(String.format("Account %s not found", fromAccount)));

        userDao.findByAccount(toAccount)
                .map(u -> { u.setAmount(u.getAmount() + amount); return  u; })
                .map(userDao::save)
                .orElseThrow(() -> new AccountNotFoundException(String.format("Account %s not found", toAccount)));

        moneyTransferHistoryDao.save(MoneyTransfer.of(fromAccount, toAccount, amount, LocalDateTime.now()));
    }
}
