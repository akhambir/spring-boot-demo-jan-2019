package com.akhambir.worker;

import com.akhambir.dao.ActionDao;
import com.akhambir.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.util.stream.Collectors.toList;

@Component
public class ActionWorker {

    @Autowired
    private ActionDao actionDao;

    @Scheduled(fixedDelay = 5000)    //(cron = "0 1 1 * * ?")
    public void executeActionProcessing() {
        actionDao.findAllByStatus(Action.Status.CREATED)
                .orElseGet(Collections::emptyList).stream()
                .peek(a -> System.out.println("Action with id: " + a.getId() + " with status: " + a.getStatus()))
                .peek(a -> a.setStatus(Action.Status.IN_PROGRESS))
                .peek(a -> System.out.println("Action with id: " + a.getId() + " with status: " + a.getStatus()))
                .peek(a -> a.setStatus(Action.Status.DONE))
                .map(actionDao::save)
                .peek(a -> System.out.println("Action with id: " + a.getId() + " with status: " + a.getStatus()))
                .collect(toList());
    }
}
