package com.venuiti.farm.dao.model.plant;

import com.venuiti.farm.dao.model.crop.CropType;
import com.venuiti.farm.dao.model.field.Field;
import com.venuiti.farm.dao.model.season.Season;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "plant", schema = "farm")
public class Plant {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "crop_type_id", nullable = false)
    private CropType cropType;
    private Double expectedProduct;
    @Enumerated(value = EnumType.STRING)
    private Season season;
    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
