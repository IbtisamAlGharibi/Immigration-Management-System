package com.Immigration.Management.Controllers;

import com.Immigration.Management.DTO.BorderControlOfficerDTO;
import com.Immigration.Management.DTO.ImmigrationOfficerDTO;
import com.Immigration.Management.Entities.BorderControlOfficer;
import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ImmigrationOfficerDTO> hireOfficer(@RequestBody ImmigrationOfficer officer) {
        return ResponseEntity.ok(ImmigrationOfficerDTO.convertToDTO(officerService.saveOfficer(officer)));
    }
    @PostMapping("/borderOfficer")
    public ResponseEntity<BorderControlOfficerDTO> hireBorderOfficer(@RequestBody BorderControlOfficer borderOfficer) {
        return ResponseEntity.ok(BorderControlOfficerDTO.convertToDTO((BorderControlOfficer) officerService.saveOfficer(borderOfficer)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ImmigrationOfficerDTO> getOfficerById(@PathVariable Long id) {
        return ResponseEntity.ok(ImmigrationOfficerDTO.convertToDTO(officerService.getOfficerById(String.valueOf(id))));
    }
    @PutMapping("/{id}/promote")
    public ResponseEntity<ImmigrationOfficerDTO> promoteOfficer(@PathVariable Long id, @RequestParam String newRank, @RequestParam int clearance) {
        return ResponseEntity.ok(ImmigrationOfficerDTO.convertToDTO(officerService.promoteOfficer(id, newRank, clearance)));
    }
    @PutMapping("/{id}/transfer/{centerId}")
    public ResponseEntity<ImmigrationOfficerDTO> transferOfficer(@PathVariable Long id, @PathVariable Long centerId) {
        return ResponseEntity.ok(ImmigrationOfficerDTO.convertToDTO(officerService.transferOfficer(id, centerId)));
    }
}
