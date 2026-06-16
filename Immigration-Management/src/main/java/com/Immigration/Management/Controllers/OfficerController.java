package com.Immigration.Management.Controllers;

import com.Immigration.Management.Entities.BorderControlOfficer;
import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/officer")
public class OfficerController {
    OfficerService officerService;
    @Autowired
    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }
    @PostMapping
    public ImmigrationOfficer hireOfficer(@RequestBody ImmigrationOfficer officer) {
        return officerService.saveOfficer(officer);
    }
    @PostMapping("/borderOfficer")
    public BorderControlOfficer hireBorderOfficer(@RequestBody BorderControlOfficer borderOfficer) {
        return (BorderControlOfficer) officerService.saveOfficer(borderOfficer);
    }
}
