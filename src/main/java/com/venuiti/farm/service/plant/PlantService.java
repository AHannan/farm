package com.venuiti.farm.service.plant;

import com.venuiti.farm.controller.plant.dto.PlantDataDTO;
import com.venuiti.farm.controller.plant.mapper.PlantMapper;
import com.venuiti.farm.dao.model.plant.Plant;
import com.venuiti.farm.dao.repository.crop.CropTypeRepository;
import com.venuiti.farm.dao.repository.field.FieldRepository;
import com.venuiti.farm.dao.repository.plant.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantedRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private CropTypeRepository cropTypeRepository;

    public void submit(PlantDataDTO plantData) {
        var plant = PlantMapper.toEntity(
                plantData,
                fieldRepository.findById(plantData.getFieldId()).orElse(null),
                cropTypeRepository.findById(plantData.getCropTypeId()).orElse(null)
        );
        plantedRepository.save(plant);
    }

    public List<PlantDataDTO> findByFarmer(String farmId) {
        List<Plant> plantedList = plantedRepository.findByFieldFarmerId(farmId);
        List<PlantDataDTO> plantedDataList = PlantMapper.mapEntitiesToDTOs(plantedList);

        return plantedDataList;
    }
}
