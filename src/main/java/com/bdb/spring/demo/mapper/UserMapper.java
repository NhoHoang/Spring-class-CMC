package com.bdb.spring.demo.mapper;

import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);
}
