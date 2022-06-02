package com.springboot.model;

import java.util.List;

public class GossipChecker {
    private static final String [] inappropriateWords = {
            "fraier", "prost", "idiot",
            "urat", "incult", "ugly",
            "loser", "stupid", "analfabet"
    };

    public static boolean isGossipInappropriate(Gossip gossip) {
        String content = gossip.getContent();

        for (var badWord : GossipChecker.inappropriateWords)
            if (content.contains(badWord))
                return true;

        return false;
    }

    public static boolean alreadyExists(List<Gossip> gossipList, Gossip gossip) {

        for (int i = 0; i < gossipList.size(); i++)
            if (gossip.getContent().equals(gossipList.get(i)))
                return true;

        return false;
    }
}
