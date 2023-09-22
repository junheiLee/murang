package com.murang.rental.data.repository;

import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUserId(String userId);
}
