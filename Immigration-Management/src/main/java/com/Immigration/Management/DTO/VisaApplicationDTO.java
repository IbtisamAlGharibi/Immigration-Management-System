package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.VisaApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisaApplicationDTO {
    private Long visaApplicationId;
    private String visaType;
    private String status;
    private String officerNotes;
    private Long applicantId;
    private Long officerId;

    public static VisaApplicationDTO convertToDTO(VisaApplication entity) {

        VisaApplicationDTO dto = new VisaApplicationDTO();
        dto.setVisaApplicationId(entity.getId());
        dto.setVisaType(entity.getVisaType());
        dto.setStatus(entity.getStatus());
        dto.setOfficerNotes(entity.getOfficerNotes());
        if (entity.getApplicant() != null) {
            dto.setApplicantId(entity.getApplicant().getId());
        }
        if (entity.getImmigrationOfficer() != null) {
            dto.setOfficerId(entity.getImmigrationOfficer().getId());
        }
        return dto;
    }
    public static List<VisaApplicationDTO> convertToDTO(List<VisaApplication> entities) {

        List<VisaApplicationDTO> dtos = new ArrayList<>();
        for (VisaApplication entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
