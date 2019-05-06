package com.akhambir.services;

import com.akhambir.model.Action;

import java.util.Optional;

public interface ActionService {
    Optional<Action> create(Action action);
}
