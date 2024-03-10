package com.venuiti.farm.controller.harvest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HarvestDataDTO {
    private Long id;
    private Double actualProduct;
    private Long cropTypeId;
    private String season;
    private Long fieldId;

}
