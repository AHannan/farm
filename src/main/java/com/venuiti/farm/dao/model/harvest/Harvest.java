package com.venuiti.farm.dao.model.harvest;

import com.venuiti.farm.dao.model.crop.CropType;
import com.venuiti.farm.dao.model.field.Field;
import com.venuiti.farm.dao.model.season.Season;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "crop_type_id", nullable = false)
    private CropType cropType;
    private Double actualProduct;
    private Season season;
    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
