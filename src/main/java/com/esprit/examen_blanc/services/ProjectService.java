//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.exceptions.EmptyException;
import com.esprit.examen_blanc.exceptions.enums.ErrorCodes;
import com.esprit.examen_blanc.repositories.ProjectRepository;
import com.esprit.examen_blanc.repositories.SprintRepository;
import com.esprit.examen_blanc.services.interfaces.IProjectService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;

    @Transactional
    public Project addProject(Project project) throws EmptyException {
        if (project.getSprints() != null && !project.getSprints().isEmpty()) {
            this.projectRepository.saveAndFlush(project);
            project.getSprints().forEach((s) -> {
                s.setProject(project);
            });
            return project;
        } else {
            throw new EmptyException("Sprints should not empty ", ErrorCodes.SHOULD_NOT_EMPTY);
        }
    }

    public ProjectService(final ProjectRepository projectRepository, final SprintRepository sprintRepository) {
        this.projectRepository = projectRepository;
        this.sprintRepository = sprintRepository;
    }
}
