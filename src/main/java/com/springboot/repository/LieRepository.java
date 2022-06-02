package com.springboot.repository;

import com.springboot.model.Lie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieRepository extends JpaRepository<Lie, Long> {
}