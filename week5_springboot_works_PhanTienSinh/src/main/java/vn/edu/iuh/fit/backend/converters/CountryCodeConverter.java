/**
 * @ (#) CountryCodeConverter.java      11/3/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.converters;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/3/2024
 */
@Converter(autoApply = true)
public class CountryCodeConverter implements AttributeConverter<CountryCode, String> {

    @Override
    public String convertToDatabaseColumn(CountryCode countryCode) {
        return (countryCode != null) ? countryCode.getAlpha2() : null;
    }

    @Override
    public CountryCode convertToEntityAttribute(String dbData) {
        return (dbData != null) ? CountryCode.getByAlpha2Code(dbData) : null;
    }
}
