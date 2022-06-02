package com.springboot.controller;

import com.springboot.model.Lie;
import com.springboot.service.LieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LieController {
    private final LieService lieService;
    private ArrayList<Lie> feed;

    public LieController(LieService lieService) {
        this.lieService = lieService;

        feed = new ArrayList<>();
    }

    @PostMapping("/api/lie")
    public ResponseEntity<Lie> sendLie(@RequestBody Lie lie) {
        return new ResponseEntity<>(lieService.saveLie(lie), HttpStatus.CREATED);
    }

    @GetMapping("/deleteLie")
    public String deleteLie(@RequestParam Long id) {
        lieService.deleteLie(id);
        return "redirect:/lieInbox";
    }

    @GetMapping("/api/lie")
    public List<Lie> getAllLies() {
        return lieService.getAllLies();
    }

    @PostMapping("/postLie")
    public String postLie(Lie lie) {
        lieService.saveLie(lie);
        feed.add(lie);
        return "redirect:/lieFeed";
    }

    @GetMapping("/lieFeed")
    public String showFeed(Model model) {
        model.addAttribute("lieFeed", feed);
        return "/lieFeed";
    }
}
