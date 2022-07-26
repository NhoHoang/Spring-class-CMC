package com.bdb.spring.demo.controller;

import com.bdb.spring.demo.dto.UserCreateDto;
import com.bdb.spring.demo.dto.UserDto;
import com.bdb.spring.demo.dto.UserUpdateDto;
import com.bdb.spring.demo.entity.User;
import com.bdb.spring.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.names}")
    private int[] appNames;

    private final UserService userService;

    @GetMapping("/get-prop")
    public ResponseEntity<?> getProperty() {
        return ResponseEntity.ok(appNames);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.create(userCreateDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.update(userUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/persist")
    public ResponseEntity<?> persistDemo() {
        userService.persistDemo();
        return ResponseEntity.ok("Check console");
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<?> removeDemo(@PathVariable Long id) {
        userService.removeDemo(id);
        return ResponseEntity.ok("Check console");
    }

}
