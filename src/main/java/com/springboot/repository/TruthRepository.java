package com.springboot.repository;

import com.springboot.model.Truth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruthRepository extends JpaRepository<Truth, Long> {
}