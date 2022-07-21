package com.bdb.spring.demo.mapper;

import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel = "spring", uses = {IdentityMapper.class})
@Mapper(uses = {IdentityMapper.class})
public interface UserMapper {
    @Mapping(source = "name",target = "nameDto")
    @Mapping(source = "identity",target = "identityDto")
    UserDto toDto(User user);
}
