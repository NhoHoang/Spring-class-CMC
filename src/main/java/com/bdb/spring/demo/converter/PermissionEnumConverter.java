package com.bdb.spring.demo.converter;

import com.bdb.spring.demo.constant.Permission;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PermissionEnumConverter implements AttributeConverter<Permission, String> {
    @Override
    public String convertToDatabaseColumn(Permission attribute) {
        return attribute.getValue();
    }

    @Override
    public Permission convertToEntityAttribute(String dbData) {
        return Permission.of(dbData);
    }
}
