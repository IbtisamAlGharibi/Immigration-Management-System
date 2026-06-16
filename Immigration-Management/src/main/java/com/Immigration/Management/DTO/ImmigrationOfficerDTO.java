package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.ImmigrationOfficer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmigrationOfficerDTO {
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

    public static ImmigrationOfficerDTO convertToDTO(ImmigrationOfficer entity) {
        ImmigrationOfficerDTO dto = new ImmigrationOfficerDTO();
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

        return dto;
    }
    public static List<ImmigrationOfficerDTO> convertToDTO(List<ImmigrationOfficer> entities) {

        List<ImmigrationOfficerDTO> dtos = new ArrayList<>();
        for (ImmigrationOfficer entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
