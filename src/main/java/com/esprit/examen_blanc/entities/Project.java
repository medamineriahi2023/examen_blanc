//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.entities;

import lombok.*;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String title;
    private String description;
    @ManyToMany(
            mappedBy = "workProjects"
    )
    private List<User> userList;
    @OneToMany(
            mappedBy = "project",
            cascade = {CascadeType.PERSIST}
    )
    private Set<Sprint> sprints;
}
