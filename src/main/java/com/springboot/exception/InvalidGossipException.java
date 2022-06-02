package com.springboot.exception;

import com.springboot.model.Gossip;

public class InvalidGossipException extends RuntimeException {

    public InvalidGossipException(Gossip gossip) {
        super(String.format("Gossip with id %s is invalid!", gossip.getId()));
    }
}
