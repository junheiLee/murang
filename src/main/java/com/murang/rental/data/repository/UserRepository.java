package com.murang.rental.data.repository;

import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findUserById(String userId);

    boolean existsUserById(String id);

}
