package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDTO {
    private Long applicantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;

    private String passportNumber;
    private String nationality;
    private boolean criminalRecord;

    public static ApplicantDTO convertToDTO(Applicant entity) {
        ApplicantDTO dto = new ApplicantDTO();
        dto.setApplicantId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setGender(entity.getGender());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setNationality(entity.getNationality());
        dto.setCriminalRecord(entity.isCriminalRecord());
        return dto;
    }
}
