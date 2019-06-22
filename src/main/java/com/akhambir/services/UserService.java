package com.akhambir.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void transferAmount(Integer fromAccount, Integer toAccount, Double amount);

}
