package com.venuiti.farm.controller.plant.dto;
import com.venuiti.farm.dao.model.season.Season;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlantDataDTO {
    private Long id;
    private Long cropTypeId;
    private Double expectedProduct;
    private Season season;
    private Long fieldId;

}
