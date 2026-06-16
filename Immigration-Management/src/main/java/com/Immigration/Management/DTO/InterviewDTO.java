package com.Immigration.Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
