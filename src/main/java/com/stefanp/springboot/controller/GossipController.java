package com.stefanp.springboot.controller;

import com.stefanp.springboot.model.Gossip;
import com.stefanp.springboot.model.User;
import com.stefanp.springboot.service.GossipService;
import com.stefanp.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GossipController {
    private final GossipService gossipService;
    private final UserService userService;

    public GossipController(GossipService gossipService, UserService userService) {
        this.gossipService = gossipService;
        this.userService = userService;
    }

    @PostMapping("/api/gossip")
    public ResponseEntity<Gossip> sendGossip(@RequestBody Gossip gossip) {
        return new ResponseEntity<>(gossipService.saveGossip(gossip), HttpStatus.CREATED);
    }

    @GetMapping("/api/gossip")
    public List<Gossip> getAllGossips() {
        return gossipService.getAllGossips();
    }

    @PostMapping("/sendGossip")
    public String getFormBack(Gossip gossip) {
        gossip.setUser_name(userService.getUser(gossip.getUser_id()).getUsername());
        gossipService.saveGossip(gossip);
        return "redirect:/feed";
    }

    @GetMapping("/sendGossip")
    public String sendFormToUser(Model model) {
        Gossip gossip = new Gossip();
        model.addAttribute("gossip", gossip);
        return "/gossipForm";
    }

    @GetMapping("/inbox")
    public String getFeed(Model model) {
        model.addAttribute("gossips", gossipService.getFeed());
        return "/inbox";
    }

    @GetMapping("/deleteGossip")
    public String deleteFeed(@RequestParam Long id) {
        gossipService.deleteGossip(id);
        return "redirect:/inbox";
    }
}
