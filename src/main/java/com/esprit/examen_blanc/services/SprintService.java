//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services;

import com.esprit.examen_blanc.entities.Sprint;
import com.esprit.examen_blanc.repositories.SprintRepository;
import com.esprit.examen_blanc.services.interfaces.ISprintService;
import org.springframework.stereotype.Service;

@Service
public class SprintService implements ISprintService {
    private final SprintRepository sprintRepository;

    public Sprint addSprint(Sprint sprint) {
        return this.sprintRepository.save(sprint);
    }

    public SprintService(final SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }
}
