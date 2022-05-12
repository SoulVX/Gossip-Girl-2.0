package com.stefanp.springboot.exception;

import com.stefanp.springboot.model.Gossip;

import java.util.List;

public class AlreadyExistsGossipException extends RuntimeException{

    public AlreadyExistsGossipException(List <Gossip> gossipList, Gossip gossip) {
        super(String.format("Gossip with id %s already exists in %s!", gossip.getId(), gossipList));
    }
}
