package com.stefanp.springboot.controller;

import com.stefanp.springboot.model.Gossip;
import com.stefanp.springboot.model.User;
import com.stefanp.springboot.service.GossipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GossipController {
    private final GossipService gossipService;

    public GossipController(GossipService gossipService) {
        this.gossipService = gossipService;
    }

    @PostMapping("/api/gossip")
    public ResponseEntity<Gossip> saveGossip(@RequestBody Gossip gossip) {
        return new ResponseEntity<>(gossipService.saveGossip(gossip), HttpStatus.CREATED);
    }

    @GetMapping("/api/gossip")
    public List<Gossip> getAllGossips() {
        return gossipService.getAllGossips();
    }

    @GetMapping("/feed")
    public String getFeed(Model model) {
        model.addAttribute("gossips", gossipService.getFeed());
        return "/feed";
    }
}
