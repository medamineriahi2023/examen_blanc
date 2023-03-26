//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.entities.Role;
import com.esprit.examen_blanc.exceptions.EmptyException;
import com.esprit.examen_blanc.exceptions.enums.ErrorCodes;
import com.esprit.examen_blanc.repositories.ProjectRepository;
import com.esprit.examen_blanc.repositories.SprintRepository;
import com.esprit.examen_blanc.services.interfaces.IProjectService;
import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    public List<Project> getNbrSprintByCurrentProject() {
        List<Project> projects = projectRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        return projects.stream().filter(project -> project.getSprints().stream().anyMatch(sprint -> sprint.getStartDate().isAfter(currentDate))).collect(Collectors.toList());
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fname, String lname) {
        return projectRepository.findAllByUsersRoleAndUsersFnameAndUsersLname(Role.SCRUM_MASTER,fname, lname);
    }

    public ProjectService(final ProjectRepository projectRepository, final SprintRepository sprintRepository) {
        this.projectRepository = projectRepository;
        this.sprintRepository = sprintRepository;
    }


}
