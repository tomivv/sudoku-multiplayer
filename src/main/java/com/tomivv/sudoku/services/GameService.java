package com.tomivv.sudoku.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomivv.sudoku.entity.Game;
import com.tomivv.sudoku.repository.GameRepository;

@Service
public class GameService {
    
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public void addNewGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    // Only used to update board and solution at this time
    @Transactional
    public void updateGame(Game game) {
        Game fetchedGame = gameRepository.findById(game.getId())
            .orElseThrow();

        fetchedGame.setBoard(game.getBoard());
        fetchedGame.setSolution(game.getSolution());

        gameRepository.save(fetchedGame);
    }
}
