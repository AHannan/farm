package com.venuiti.farm.dao.repository.plant;

import com.venuiti.farm.dao.model.plant.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByFieldFarmerId(Long farmerId);
    List<Plant> findByCropTypeId(Long cropType);
}
