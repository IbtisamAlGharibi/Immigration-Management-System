package com.Immigration.Management.Controllers;

import com.Immigration.Management.Entities.BorderControlOfficer;
import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ImmigrationOfficer getOfficerById(@PathVariable Long id) {
        return officerService.getOfficerById(String.valueOf(id));
    }
    @PutMapping("/{id}/promote")
    public ImmigrationOfficer promoteOfficer(@PathVariable Long id, @RequestParam String newRank, @RequestParam int clearance) {
        return officerService.promoteOfficer(id, newRank, clearance);
    }
    @PutMapping("/{id}/transfer/{centerId}")
    public ImmigrationOfficer transferOfficer(@PathVariable Long id, @PathVariable Long centerId) {
        return officerService.transferOfficer(id, centerId);
    }
}
