package com.akhambir.services;

import com.akhambir.dao.ActionDao;
import com.akhambir.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionDao actionDao;

    @Override
    public Optional<Action> create(Action action) {
        action.setStatus(Action.Status.CREATED);
        return Optional.of(actionDao.save(action));
    }
}
