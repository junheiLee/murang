package com.murang.rental.data.repository;

import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> { }
