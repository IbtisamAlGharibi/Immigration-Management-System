package com.Immigration.Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
