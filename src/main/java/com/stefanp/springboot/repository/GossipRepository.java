package com.stefanp.springboot.repository;

import com.stefanp.springboot.model.Gossip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GossipRepository extends JpaRepository<Gossip, Long> {
}
