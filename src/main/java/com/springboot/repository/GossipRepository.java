package com.springboot.repository;

import com.springboot.model.Gossip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GossipRepository extends JpaRepository<Gossip, Long> {
}
