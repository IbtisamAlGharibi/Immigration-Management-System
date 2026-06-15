package com.Immigration.Management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImmigrationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    @OneToMany
    List<ImmigrationOfficer> immigrationOfficers;
}
