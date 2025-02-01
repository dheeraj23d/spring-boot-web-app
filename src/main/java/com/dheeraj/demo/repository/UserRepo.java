package com.dheeraj.demo.repository;

import com.dheeraj.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByusername(String username);
}
