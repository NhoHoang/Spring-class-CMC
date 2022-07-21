package com.bdb.spring.demo.repository;

import com.bdb.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
