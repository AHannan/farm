package com.venuiti.farm.service.report;

import com.venuiti.farm.dao.model.harvest.Harvest;
import com.venuiti.farm.dao.model.plant.Plant;
import com.venuiti.farm.dao.repository.harvest.HarvestRepository;
import com.venuiti.farm.dao.repository.plant.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private HarvestRepository harvestRepository;

    public String generateFarmReport(Long farmId) {
        List<Plant> plantedData = plantRepository.findByFieldFarmerId(farmId);
        List<Harvest> harvestedData = harvestRepository.findByFieldFarmerId(farmId);

        double totalExpected = plantedData.stream().mapToDouble(Plant::getExpectedProduct).sum();
        double totalActual = harvestedData.stream().mapToDouble(Harvest::getActualProduct).sum();

        StringBuilder report = new StringBuilder();
        report.append("Farm Report for Farm ID ").append(farmId).append("\n");
        report.append("Total Expected Product: ").append(totalExpected).append(" tons\n");
        report.append("Total Actual Product: ").append(totalActual).append(" tons\n");

        return report.toString();
    }

    public String generateCropReport(String cropType) {
        List<Plant> plantedData = plantRepository.findByCropType(cropType);
        List<Harvest> harvestedData = harvestRepository.findByCropType(cropType);

        double totalExpected = plantedData.stream().mapToDouble(Plant::getExpectedProduct).sum();
        double totalActual = harvestedData.stream().mapToDouble(Harvest::getActualProduct).sum();

        StringBuilder report = new StringBuilder();
        report.append("Crop Report for Crop Type ").append(cropType).append("\n");
        report.append("Total Expected Product: ").append(totalExpected).append(" tons\n");
        report.append("Total Actual Product: ").append(totalActual).append(" tons\n");

        return report.toString();
    }
}
