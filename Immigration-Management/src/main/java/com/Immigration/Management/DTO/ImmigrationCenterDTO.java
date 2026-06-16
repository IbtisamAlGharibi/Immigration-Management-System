package com.Immigration.Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmigrationCenterDTO {
    private Long centerId;
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;
}
