//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services.interfaces;

import com.esprit.examen_blanc.entities.User;
import com.esprit.examen_blanc.exceptions.EntityNotFoundException;

public interface IUserService {
    User addUser(User user);

    void assignProjectToUser(Long projectId, Long userId) throws EntityNotFoundException;

    void assignProjectToClient(Long projectId, String firstName, String lastName) throws EntityNotFoundException;
}
