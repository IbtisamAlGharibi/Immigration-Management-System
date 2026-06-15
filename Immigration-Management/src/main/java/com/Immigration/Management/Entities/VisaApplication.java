package com.Immigration.Management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisaApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String visaType;
    private String status;
    private String officerNotes;

    @ManyToOne
    private Applicant applicant;
    @ManyToOne
    private ImmigrationOfficer immigrationOfficer;

}
