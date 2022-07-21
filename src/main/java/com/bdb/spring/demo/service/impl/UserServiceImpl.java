package com.bdb.spring.demo.service.impl;

import com.bdb.spring.demo.constant.Gender;
import com.bdb.spring.demo.dto.UserCreateDto;
import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.dto.UserUpdateDto;
import com.bdb.spring.demo.entity.Identity;
import com.bdb.spring.demo.entity.User;
import com.bdb.spring.demo.mapper.UserMapper;
import com.bdb.spring.demo.repository.UserRepository;
import com.bdb.spring.demo.service.UserService;
import com.mysql.cj.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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
    public void persistDemo() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // create 2 new entity
        User user = new User("Ngyuen Van A", Gender.of("m"));
        Identity identity = new Identity("011115646546");
        // set
        identity.setUser(user);
        user.setIdentity(identity);
        //persist
        entityManager.persist(user);
        //commit
        entityManager.getTransaction().commit();
        System.out.println("-------------------");
        System.out.println(user);
        System.out.println(identity);

        entityManager.close();

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
