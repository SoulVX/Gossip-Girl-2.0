package com.stefanp.springboot.service;

import com.stefanp.springboot.model.Gossip;

import java.util.List;

public interface GossipService {
    Gossip saveGossip(Gossip gossip);
    List<Gossip> getAllGossips();
    Gossip getGossip(long id);
    Gossip updateGossip(long id);
    void deleteGossip(long id);
    List<Gossip> getFeed();
}
