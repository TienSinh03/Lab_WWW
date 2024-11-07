/**
 * @ (#) SkillLevelConvert.java      11/7/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SkillLevel skillLevel) {
        if (skillLevel == null) {
            return null;
        }
        return skillLevel.getValue();
    }

    @Override
    public SkillLevel convertToEntityAttribute(Integer value) {
        if (value == null) {
            return null;
        }
        for (SkillLevel level : SkillLevel.values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Unknown SkillLevel value: " + value);
    }
}
