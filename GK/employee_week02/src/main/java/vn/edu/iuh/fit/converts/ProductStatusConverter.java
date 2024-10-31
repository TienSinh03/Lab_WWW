/**
 * @ (#) ProductStatusConverter.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2_phantiensinh.enums.ProductStatus;

import java.util.stream.Stream;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
@Converter(autoApply = true )
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if(attribute==null){
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null){
            return null;
        }
        return Stream.of(ProductStatus.values())
                .filter(c-> c.getValue() ==dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
