package com.venuiti.farm.dao.repository.farmer;

import com.venuiti.farm.dao.model.farmer.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, String> {
}
