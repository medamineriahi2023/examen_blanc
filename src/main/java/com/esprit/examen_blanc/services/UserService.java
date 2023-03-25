//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.entities.User;
import com.esprit.examen_blanc.exceptions.EntityNotFoundException;
import com.esprit.examen_blanc.exceptions.enums.ErrorCodes;
import com.esprit.examen_blanc.repositories.ProjectRepository;
import com.esprit.examen_blanc.repositories.UserRepository;
import com.esprit.examen_blanc.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    public void assignProjectToUser(Long projectId, Long userId) throws EntityNotFoundException {
        Project project = this.projectRepository.findById(projectId).orElseThrow(() ->
            new EntityNotFoundException("entity project with id " + projectId + " not found", ErrorCodes.ENTITY_NOT_FOUND)
        );
        User user = this.userRepository.findById(userId).orElseThrow(() ->
             new EntityNotFoundException("entity User with id = " + userId + " not found", ErrorCodes.ENTITY_NOT_FOUND)
        );
        user.getWorkProjects().add(project);
    }

    @Transactional
    public void assignProjectToClient(Long projectId, String firstName, String lastName) throws EntityNotFoundException {
        Project project = this.projectRepository.findById(projectId).orElseThrow(() ->
             new EntityNotFoundException("entity project with id = " + projectId + " not found", ErrorCodes.ENTITY_NOT_FOUND)
        );
        User user = this.userRepository.findByFnameAndLname(firstName, lastName).orElseThrow(() ->
             new EntityNotFoundException("entity project with firstname = " + firstName + " and " + lastName + " not found", ErrorCodes.ENTITY_NOT_FOUND));
        user.getProjects().add(project);
    }

    public UserService(final UserRepository userRepository, final ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }
}
