package com.bdb.spring.demo.service;

import com.bdb.spring.demo.dto.UserCreateDto;
import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.dto.UserUpdateDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getOne(Long id);

    UserDto create(UserCreateDto userCreateDto);

    UserDto update(UserUpdateDto userUpdateDto);

    void delete(Long id);

    Page<UserDto> getAll2(Pageable pageable);
}

//controllers work with response entity
//services work with both dtos and entities (params: dto, return: dto)
//repos work with entities