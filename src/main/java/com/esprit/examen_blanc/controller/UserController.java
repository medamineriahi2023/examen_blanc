//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.controller;

import com.esprit.examen_blanc.entities.User;
import com.esprit.examen_blanc.exceptions.EntityNotFoundException;
import com.esprit.examen_blanc.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"user"}
)
public class UserController {
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity(this.userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping(
            path = {"/{projectId}/{userId}"}
    )
    public ResponseEntity<User> assignProjectToUser(@PathVariable Long projectId, @PathVariable Long userId) throws EntityNotFoundException {
        this.userService.assignProjectToUser(projectId, userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(
            path = {"/{projectId}/{firstName}/{lastName}"}
    )
    public ResponseEntity<User> assignProjectToClient(@PathVariable Long projectId, @PathVariable String firstName, @PathVariable String lastName) throws EntityNotFoundException {
        this.userService.assignProjectToClient(projectId, firstName, lastName);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public UserController(final IUserService userService) {
        this.userService = userService;
    }
}
