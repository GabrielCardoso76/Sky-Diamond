package com.example.bloukemon.controller;

import com.example.bloukemon.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("map", gameService.getMap());
        model.addAttribute("playerX", gameService.getPlayerX());
        model.addAttribute("playerY", gameService.getPlayerY());
        return "index";
    }

    @PostMapping("/move")
    public String move(@RequestParam String direction) {
        gameService.movePlayer(direction);
        return "redirect:/";
    }
}