package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.Interview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewDTO {
    private Long interviewId;
    private String interviewDate;
    private String status;
    private String purpose;
    private Long applicantId;
    private Long officerId;

    public static InterviewDTO convertToDTO(Interview entity) {

        InterviewDTO dto = new InterviewDTO();
        dto.setInterviewId(entity.getId());
        dto.setInterviewDate(entity.getInterviewDate());
        dto.setStatus(entity.getStatus());
        dto.setPurpose(entity.getPurpose());
        if (entity.getApplicant() != null) {
            dto.setApplicantId(entity.getApplicant().getId());
        }
        if (entity.getImmigrationOfficer() != null) {
            dto.setOfficerId(entity.getImmigrationOfficer().getId());
        }
        return dto;
    }


    public static List<InterviewDTO> convertToDTO(List<Interview> entities) {

        List<InterviewDTO> dtos = new ArrayList<>();
        for (Interview entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
