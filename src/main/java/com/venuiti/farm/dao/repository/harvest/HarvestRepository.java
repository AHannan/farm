package com.venuiti.farm.dao.repository.harvest;

import com.venuiti.farm.dao.model.harvest.Harvest;
import com.venuiti.farm.dao.model.season.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, String> {
    boolean existsBySeasonAndFieldIdAndCropTypeId(Season season, String fieldId, String cropTypeId);
    List<Harvest> findByFieldFarmerId(String farmerId);
    List<Harvest> findByCropTypeId(String cropType);
}
