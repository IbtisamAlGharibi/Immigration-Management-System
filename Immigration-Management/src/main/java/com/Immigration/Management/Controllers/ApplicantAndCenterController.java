package com.Immigration.Management.Controllers;

import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.ImmigrationCenter;
import com.Immigration.Management.Repositories.CenterRepository;
import com.Immigration.Management.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicantAndCenterController {
    ApplicantService applicantService;
    CenterRepository centerRepository;
    @Autowired
    public ApplicantAndCenterController(ApplicantService applicantService) {
        this.applicantService = applicantService;
        this.centerRepository = centerRepository;
    }

    @PostMapping("/addCenter")
    public ImmigrationCenter createCenter(@RequestBody ImmigrationCenter immigrationCenter){
        return centerRepository.save(immigrationCenter);
    }
    @GetMapping("/{id}")
    public ImmigrationCenter getCenter(@PathVariable Long id){
        return centerRepository.getReferenceById(id);
    }

    @PostMapping("/registerApplicant")
    public Applicant registerApplicant(Applicant applicant){
       return applicantService.saveApplicant(applicant);
    }
}
