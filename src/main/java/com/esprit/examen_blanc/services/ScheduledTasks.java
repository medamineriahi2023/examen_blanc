package com.esprit.examen_blanc.services;

import com.esprit.examen_blanc.entities.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ScheduledTasks {


    private final ProjectService projectService;

    @Scheduled(fixedRate = 30000)
    public void reportCurrentSprints() {
        List<Project> projects = projectService.getNbrSprintByCurrentProject();
        log.info("Nombre de projets avec des sprints en cours : {}", projects.size());

        for (Project project : projects) {
            log.info("Projet '{}' (ID: {}) a {} sprints en cours.", project.getTitle(), project.getId(), project.getSprints().size());
        }
    }
}