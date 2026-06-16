package com.Immigration.Management.Controllers;

import com.Immigration.Management.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantAndCenterController {
    ApplicantService applicantService;
    @Autowired
    public ApplicantAndCenterController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }


}
