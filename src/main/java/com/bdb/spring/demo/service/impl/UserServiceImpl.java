package com.bdb.spring.demo.service.impl;

import com.bdb.spring.demo.config.HibernateUtils;
import com.bdb.spring.demo.constant.Gender;
import com.bdb.spring.demo.constant.Permission;
import com.bdb.spring.demo.dto.UserCreateDto;
import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.dto.UserUpdateDto;
import com.bdb.spring.demo.entity.Identity;
import com.bdb.spring.demo.entity.User;
import com.bdb.spring.demo.mapper.UserMapper;
import com.bdb.spring.demo.repository.UserRepository;
import com.bdb.spring.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.security.auth.login.Configuration;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    @PersistenceContext
//    private EntityManager entityManager;

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(this::userDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getOne(Long id) {
        return userDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        User user = user(userCreateDto);
        user = userRepository.save(user);
        return userDto(user);
    }

    @Override
    public UserDto update(UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(userUpdateDto.getId()).orElseThrow();
        user = userRepository.save(user(userUpdateDto, user));
        return userDto(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void persistDemo() {
        Session session = HibernateUtils.getInstance().openSession();

        List<Permission> permissions = new ArrayList<>();
        Permission permission = Permission.of("r");
        permissions.add(permission);
        // create 2 new entity
        User user = new User("Ngyuen Van A11", Gender.of("m"),permissions );
        Identity identity = new Identity("0111151646546");
        // set
        identity.setUser(user);
        user.setIdentity(identity);
        userRepository.save(user);
        session.close();
        HibernateUtils.getInstance().closeFactory();
        System.out.println("-------------------");

    }

    @Override
    @Transactional
    public void removeDemo(Long id) {
        userRepository.deleteById(id);
    }

    private User user(UserUpdateDto userUpdateDto, User user) {
        user.setName(userUpdateDto.getName());
        return user;
    }

    private User user(UserCreateDto userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.getName());
        return user;
    }

    private UserDto userDto(User user) {
        return userMapper.toDto(user);
    }

}
