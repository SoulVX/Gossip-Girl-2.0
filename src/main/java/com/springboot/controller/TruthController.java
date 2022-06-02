package com.springboot.controller;

import com.springboot.model.Truth;
import com.springboot.service.TruthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TruthController {
    private final TruthService truthService;

    public TruthController(TruthService truthService) {
        this.truthService = truthService;
    }

    @PostMapping("/api/truth")
    public ResponseEntity<Truth> sendTruth(@RequestBody Truth truth) {
        return new ResponseEntity<>(truthService.saveTruth(truth), HttpStatus.CREATED);
    }

    @GetMapping("/deleteTruth")
    public String deleteTruths(@RequestParam Long id) {
        truthService.deleteTruth(id);
        return "redirect:/truthInbox";
    }

    @GetMapping("/api/truth")
    public List<Truth> getAllTruths() {
        return truthService.getAllTruths();
    }
}
