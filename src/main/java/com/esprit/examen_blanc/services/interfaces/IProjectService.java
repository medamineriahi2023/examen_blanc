//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.services.interfaces;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.exceptions.EmptyException;

public interface IProjectService {
    Project addProject(Project project) throws EmptyException;
}
