//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.entities;

import lombok.*;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

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
            cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER
    )
    private Set<Sprint> sprints;
}
