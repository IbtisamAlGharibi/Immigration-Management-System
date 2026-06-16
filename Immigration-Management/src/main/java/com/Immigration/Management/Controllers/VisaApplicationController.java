package com.Immigration.Management.Controllers;

import com.Immigration.Management.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visaApplication")
public class VisaApplicationController {
   VisaApplicationService visaApplicationService;
    @Autowired
    public VisaApplicationController(VisaApplicationService visaApplicationService) {
        this.visaApplicationService = visaApplicationService;
    }
}
