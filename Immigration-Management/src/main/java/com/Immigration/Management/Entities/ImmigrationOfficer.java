package com.Immigration.Management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImmigrationOfficer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private boolean isActive;

    @OneToMany
    List<Interview> interviews;

}
