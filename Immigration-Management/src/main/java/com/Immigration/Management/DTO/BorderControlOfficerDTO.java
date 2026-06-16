package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.BorderControlOfficer;
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

    public static BorderControlOfficerDTO convertToDTO(BorderControlOfficer entity) {

        BorderControlOfficerDTO dto = new BorderControlOfficerDTO();
        dto.setOfficerId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setGender(entity.getGender());
        dto.setBadgeNumber(entity.getBadgeNumber());
        dto.setOfficerRank(entity.getOfficerRank());
        dto.setClearanceLevel(entity.getClearanceLevel());
        dto.setActive(entity.isActive());
        dto.setAssignedCheckPoint(entity.getAssignedCheckPoint());
        dto.setK9UnitAssigned(entity.isK9UnitAssigned());

        return dto;
    }

}
