package com.Immigration.Management.Controllers;

import com.Immigration.Management.DTO.VisaApplicationDTO;
import com.Immigration.Management.Entities.VisaApplication;
import com.Immigration.Management.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visaApplication")
public class VisaApplicationController {
   VisaApplicationService visaApplicationService;
    @Autowired
    public VisaApplicationController(VisaApplicationService visaApplicationService) {
        this.visaApplicationService = visaApplicationService;
    }
    @PostMapping("/submit/{applicantId}")
    public ResponseEntity<VisaApplicationDTO> submitVisa(@PathVariable Long applicantId, @RequestParam("type") String visaType) {
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationService.SubmitApplication(applicantId, visaType)));
    }
    @PutMapping("/{visaId}/assign/{officerId}")
    public ResponseEntity<VisaApplicationDTO> assignOfficer(@PathVariable Long visaId,@PathVariable Long officerId) {
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationService.assignOfficer(visaId, officerId)));
    }
    @PutMapping("/{visaId}/process")
    public ResponseEntity<VisaApplicationDTO> processVisa(@PathVariable Long visaId, @RequestParam String status,
                                       @RequestParam String notes) {
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO( visaApplicationService.ProcessVisa(visaId, status, notes)));
    }
    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<VisaApplicationDTO>> getVisasByApplicant(@PathVariable Long applicantId) {
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationService.getVisasByApplicantId(applicantId)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<VisaApplicationDTO>> getVisasByStatus(@PathVariable String status) {
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationService.getVisasByStatus(status)));
    }
}
