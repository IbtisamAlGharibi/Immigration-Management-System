package com.Immigration.Management.DTO;

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
}
