package com.bdb.spring.demo.dto;

import com.bdb.spring.demo.constant.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String name;
    private Gender genderId;
}
