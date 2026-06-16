package com.Immigration.Management.Controllers;

import com.Immigration.Management.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficerController {
    OfficerService officerService;
    @Autowired
    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }
}
