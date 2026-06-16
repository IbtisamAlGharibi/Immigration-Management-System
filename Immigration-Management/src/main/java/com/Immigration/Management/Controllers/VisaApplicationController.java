package com.Immigration.Management.Controllers;

import com.Immigration.Management.Entities.VisaApplication;
import com.Immigration.Management.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visaApplication")
public class VisaApplicationController {
   VisaApplicationService visaApplicationService;
    @Autowired
    public VisaApplicationController(VisaApplicationService visaApplicationService) {
        this.visaApplicationService = visaApplicationService;
    }
    @PostMapping("/submit/{applicantId}")
    public VisaApplication submitVisa(@PathVariable Long applicantId, @RequestParam("type") String visaType) {
        return visaApplicationService.SubmitApplication(applicantId, visaType);
    }
    @PutMapping("/{visaId}/assign/{officerId}")
    public VisaApplication assignOfficer(@PathVariable Long visaId,@PathVariable Long officerId) {
        return visaApplicationService.assignOfficer(visaId, officerId);
    }
}
