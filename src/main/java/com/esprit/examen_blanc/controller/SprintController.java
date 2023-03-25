//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.controller;

import com.esprit.examen_blanc.entities.Sprint;
import com.esprit.examen_blanc.services.interfaces.ISprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"sprint"}
)
public class SprintController {
    private final ISprintService iSprintService;

    @PostMapping
    public ResponseEntity<Sprint> saveUser(@RequestBody Sprint sprint) {
        return new ResponseEntity(this.iSprintService.addSprint(sprint), HttpStatus.CREATED);
    }

    public SprintController(final ISprintService iSprintService) {
        this.iSprintService = iSprintService;
    }
}
