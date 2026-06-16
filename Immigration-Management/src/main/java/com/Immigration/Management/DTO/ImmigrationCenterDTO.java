package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.ImmigrationCenter;
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

    public static ImmigrationCenterDTO convertToDTO(ImmigrationCenter entity) {

        ImmigrationCenterDTO dto = new ImmigrationCenterDTO();
        dto.setCenterId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocationCountry(entity.getLocationCountry());
        dto.setType(entity.getType());
        dto.setDailyCapacity(entity.getDailyCapacity());
        return dto;
    }
}
