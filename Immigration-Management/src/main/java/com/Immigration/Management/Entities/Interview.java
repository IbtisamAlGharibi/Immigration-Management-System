package com.Immigration.Management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interviewDate;
    private String status;
    private String purpose;

    @ManyToOne
    private ImmigrationOfficer immigrationOfficer;

}
