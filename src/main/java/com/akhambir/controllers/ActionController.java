package com.akhambir.controllers;

import com.akhambir.model.Action;
import com.akhambir.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.akhambir.controllers.ControllersUtil.getUri;

@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public ResponseEntity<Action> createAction(@RequestBody Action action) {
        return actionService.create(action)
                .map(a -> ResponseEntity.created(getUri("action", a.getId())).body(a))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }

}
