//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.repositories;

import com.esprit.examen_blanc.entities.Project;
import com.esprit.examen_blanc.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByUsersRoleAndUsersFnameAndUsersLname(Role role, String fname, String lname);
}
