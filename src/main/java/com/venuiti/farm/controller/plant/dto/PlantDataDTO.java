package com.venuiti.farm.controller.plant.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlantDataDTO {
    private Long id;
    private Long cropTypeId;
    private Double expectedProduct;
    private String season;
    private Long fieldId;

}
