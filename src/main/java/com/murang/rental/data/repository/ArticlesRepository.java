package com.murang.rental.data.repository;

import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles,Integer> { }
