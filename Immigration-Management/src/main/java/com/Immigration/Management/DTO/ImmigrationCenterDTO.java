package com.Immigration.Management.DTO;

import com.Immigration.Management.Entities.ImmigrationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    public static List<ImmigrationCenterDTO> convertToDTO(List<ImmigrationCenter> entities) {

        List<ImmigrationCenterDTO> dtos = new ArrayList<>();
        for (ImmigrationCenter entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
