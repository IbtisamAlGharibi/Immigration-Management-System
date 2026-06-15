package com.Immigration.Management.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private String nationality;
    private boolean criminalRecord;

    @OneToMany
    List<VisaApplication> visaApplications;
    @OneToMany
    List<Interview> interviews;

}
