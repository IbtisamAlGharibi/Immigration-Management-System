package com.Immigration.Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorderControlOfficerDTO {
    private Long officerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String badgeNumber;
    private String officerRank;
    private int clearanceLevel;
    private boolean active;
    private String assignedCheckPoint;
    private boolean k9UnitAssigned;
}
