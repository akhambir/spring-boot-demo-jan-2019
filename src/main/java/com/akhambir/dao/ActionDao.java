package com.akhambir.dao;

import com.akhambir.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActionDao extends JpaRepository<Action, Long> {

    Optional<List<Action>> findAllByStatus(Action.Status status);

}
