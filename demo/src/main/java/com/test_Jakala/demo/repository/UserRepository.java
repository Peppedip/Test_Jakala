package com.test_Jakala.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test_Jakala.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
