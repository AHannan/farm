package com.venuiti.farm.dao.repository.harvest;

import com.venuiti.farm.dao.model.harvest.Harvest;
import com.venuiti.farm.dao.model.season.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    boolean existsBySeasonAndFieldIdAndCropTypeId(Season season, Long fieldId, Long cropTypeId);
    List<Harvest> findByFieldFarmerId(Long farmerId);
    List<Harvest> findByCropTypeId(Long cropType);
}
