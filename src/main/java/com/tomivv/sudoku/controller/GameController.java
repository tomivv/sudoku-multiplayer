package com.tomivv.sudoku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomivv.sudoku.entity.Game;
import com.tomivv.sudoku.services.GameService;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {
    
    private final GameService gameService;

    @Autowired
    public GameController(GameService ganeGameService) {
        this.gameService = ganeGameService;
    }

    @GetMapping()
    public List<Game> getGames() {
        return gameService.getGames();
    }
}
