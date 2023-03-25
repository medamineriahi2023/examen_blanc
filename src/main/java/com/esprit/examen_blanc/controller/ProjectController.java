package com.esprit.examen_blanc.controller;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.exceptions.EmptyException;
import com.esprit.examen_blanc.services.interfaces.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"project"}
)
public class ProjectController {
    private final IProjectService iProjectService;

    @PostMapping
    public ResponseEntity<Project> saveUser(@RequestBody Project project) throws EmptyException {
        return new ResponseEntity(this.iProjectService.addProject(project), HttpStatus.CREATED);
    }

    public ProjectController(final IProjectService iProjectService) {
        this.iProjectService = iProjectService;
    }
}
