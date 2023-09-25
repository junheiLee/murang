package com.murang.rental.data.repository;

import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);

    public Optional<User> findByUserIdAndPassword(String userId, String password);
}
