package com.Immigration.Management.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorderControlOfficer extends ImmigrationOfficer {
    private String assignedCheckPoint;
    private boolean k9UnitAssigned;

}
