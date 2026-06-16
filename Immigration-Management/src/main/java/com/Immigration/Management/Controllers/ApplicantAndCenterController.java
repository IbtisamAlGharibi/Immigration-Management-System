package com.Immigration.Management.Controllers;

import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.AsylumSeeker;
import com.Immigration.Management.Entities.ImmigrationCenter;
import com.Immigration.Management.Repositories.CenterRepository;
import com.Immigration.Management.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantAndCenterController {
    ApplicantService applicantService;
    CenterRepository centerRepository;
    @Autowired
    public ApplicantAndCenterController(ApplicantService applicantService,CenterRepository centerRepository) {
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
    public Applicant registerApplicant(@RequestBody Applicant applicant){
       return applicantService.saveApplicant(applicant);
    }
    @PostMapping("/addAsylum")
    public AsylumSeeker addAsylum(@RequestBody AsylumSeeker asylumSeeker){
        return (AsylumSeeker) applicantService.saveApplicant(asylumSeeker);
    }
    @GetMapping("/getAllApplicant")
    public List<Applicant> getAllApplicant(){
        return applicantService.getAllApplicant();
    }

    @GetMapping("/search")
    public List<Applicant> getApplicantsByNationality(@RequestParam String nationality) {
        return applicantService.getApplicantByNationality(nationality);
    }
    @PutMapping("/{id}/flag")
    public Applicant flagCriminalRecord(@PathVariable Long id) {
        return applicantService.flagCriminalRecord(id);
    }
}
