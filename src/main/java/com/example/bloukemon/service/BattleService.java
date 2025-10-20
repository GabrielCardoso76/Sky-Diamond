package com.example.bloukemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    @Autowired
    private GameService gameService;

    public void handleBattleAction(String action) {
        // Simple logic for now: both actions end the battle
        gameService.setInBattle(false);
    }
}
