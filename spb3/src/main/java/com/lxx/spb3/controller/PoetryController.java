package com.lxx.spb3.controller;

import com.lxx.spb3.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PoetryController {

    private final PoetryService poetryService;

    @Autowired
    public PoetryController(PoetryService poetryService) {
        this.poetryService = poetryService;
    }

    @GetMapping("/poetry")
    public String generatePoetry(@RequestParam("theme") String theme, @RequestParam("genre") String genre) {
        return poetryService.generatePoetry(theme, genre);
    }
}
