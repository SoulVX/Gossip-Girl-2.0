package com.springboot.service.impl;

import com.springboot.model.Gossip;
import com.springboot.service.GossipService;
import com.springboot.repository.GossipRepository;
import com.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GossipServiceImpl implements GossipService {

    private GossipRepository gossipRepository;
    private UserRepository userRepository;

    public GossipServiceImpl(GossipRepository gossipRepository, UserRepository userRepository) {
        this.gossipRepository = gossipRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Gossip saveGossip(Gossip gossip) {
        return gossipRepository.save(gossip);
    }

    @Override
    public List<Gossip> getAllGossips() {
        return gossipRepository.findAll();
    }

    @Override
    public Gossip getGossip(long id) {
        return gossipRepository.findById(id).orElseThrow();
    }

    @Override
    public Gossip updateGossip(long id) {
        return null;
    }

    @Override
    public void deleteGossip(long id) {
        gossipRepository.delete(getGossip(id));
    }

    @Override
    public List<Gossip> getFeed() {
        List<Gossip> rez = new ArrayList<>();
        for(Gossip g : getAllGossips()) {
            if(g.getIsHidden())
                continue;
            if(g.getIsPinned())
                rez.add(0, g);
            else
                rez.add(g);
        }
        return rez;
    }
}
