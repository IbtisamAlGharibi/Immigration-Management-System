package com.Immigration.Management.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AsylumSeeker extends Applicant{
    private String countryOfOrigin;
    private String sponsorOrganization;

}
