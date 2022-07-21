package com.bdb.spring.demo.mapper;

import com.bdb.spring.demo.dto.IdentityDto;
import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.entity.Identity;
import com.bdb.spring.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IdentityMapper {
    @Mapping(source = "idNumber",target = "idNumberDto")
    IdentityDto toDto(Identity identity);
}
