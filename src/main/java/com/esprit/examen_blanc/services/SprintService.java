//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.entities.Sprint;
import com.esprit.examen_blanc.repositories.ProjectRepository;
import com.esprit.examen_blanc.repositories.SprintRepository;
import com.esprit.examen_blanc.services.interfaces.ISprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SprintService implements ISprintService {
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;

    public Sprint addSprint(Sprint sprint) {
        return this.sprintRepository.save(sprint);
    }

    public SprintService(final SprintRepository sprintRepository, ProjectRepository projectRepository) {
        this.sprintRepository = sprintRepository;
        this.projectRepository = projectRepository;
    }

    public Sprint addSprintAndAssignToProject(Sprint sprint, Long idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        Assert.notNull(project, "Project not found");
        sprint.setProject(project);
        sprintRepository.saveAndFlush(sprint);
        return sprint;
    }
}
