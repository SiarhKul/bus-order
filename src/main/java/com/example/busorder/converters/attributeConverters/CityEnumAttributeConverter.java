package com.example.busorder.converters.attributeConverters;

import com.example.busorder.enums.Cities;
import jakarta.persistence.AttributeConverter;
        import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CityEnumAttributeConverter implements AttributeConverter<Cities, String> {

    @Override
    public String convertToDatabaseColumn(Cities attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getShortName();
    }

    @Override
    public Cities convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Cities.create(dbData);
    }
}