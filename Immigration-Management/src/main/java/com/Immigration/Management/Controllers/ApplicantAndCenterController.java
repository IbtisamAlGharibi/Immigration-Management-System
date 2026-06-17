package com.Immigration.Management.Controllers;

import com.Immigration.Management.DTO.ApplicantDTO;
import com.Immigration.Management.DTO.AsylumSeekerDTO;
import com.Immigration.Management.DTO.ImmigrationCenterDTO;
import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.AsylumSeeker;
import com.Immigration.Management.Entities.ImmigrationCenter;
import com.Immigration.Management.Repositories.CenterRepository;
import com.Immigration.Management.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ImmigrationCenterDTO> createCenter(@RequestBody ImmigrationCenter immigrationCenter){
        return ResponseEntity.ok( ImmigrationCenterDTO.convertToDTO(centerRepository.save(immigrationCenter)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ImmigrationCenterDTO> getCenter(@PathVariable Long id){
        return ResponseEntity.ok(ImmigrationCenterDTO.convertToDTO(centerRepository.getReferenceById(id)));
    }

    @PostMapping("/registerApplicant")
    public ResponseEntity<ApplicantDTO> registerApplicant(@RequestBody Applicant applicant){
       return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.saveApplicant(applicant)));
    }
    @PostMapping("/addAsylum")
    public ResponseEntity<AsylumSeekerDTO> addAsylum(@RequestBody AsylumSeeker asylumSeeker){
        return ResponseEntity.ok (AsylumSeekerDTO.convertToDTO((AsylumSeeker) applicantService.saveApplicant(asylumSeeker)));
    }
    @GetMapping("/getAllApplicant")
    public ResponseEntity<List<ApplicantDTO>> getAllApplicant(){
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.getAllApplicant()));
    }

    @GetMapping("/search")
    public ResponseEntity <List<ApplicantDTO>> getApplicantsByNationality(@RequestParam String nationality) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.getApplicantByNationality(nationality)));
    }
    @PutMapping("/{id}/flag")
    public ResponseEntity<ApplicantDTO> flagCriminalRecord(@PathVariable Long id) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.flagCriminalRecord(id)));
    }
}
