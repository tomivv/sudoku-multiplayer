package com.tomivv.sudoku;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tomivv.sudoku.entity.Game;
import com.tomivv.sudoku.repository.GameRepository;
import com.tomivv.sudoku.services.GameService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    
    @Mock
    private GameRepository gameRepository;

    private GameService underTest;

    @BeforeEach
    void setUp() {
        underTest = new GameService(gameRepository);
    }

    @Test
    void canGetAllGames() {
        underTest.getGames();

        verify(gameRepository).findAll();
    }

    @Test
    void canAddNewGame() {
        Game game = new Game("Test game", "", "1234456781235623x1234x12x123x", "4213534523453124121242134");

        underTest.addNewGame(game);

        ArgumentCaptor<Game> gameArgumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository).save(gameArgumentCaptor.capture());
        Game capturedGame = gameArgumentCaptor.getValue();

        assertThat(capturedGame).isEqualTo(game);
    }

    @Test
    void canDeleteGame() {
        underTest.deleteGameById(anyLong());

        verify(gameRepository).deleteById(anyLong());
    }

    @Test
    void canUpdateGame() {
        Game game = new Game("Test game", "", "1234456781235623x1234x12x123x", "4213534523453124121242134");

        given(gameRepository.findById(anyLong()))
            .willReturn(Optional.of(new Game("Test game", "", "1234123412341234", "12345623456243566")));

        underTest.updateGame(game);

        ArgumentCaptor<Game> gameArgumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository).save(gameArgumentCaptor.capture());
        Game capturedGame = gameArgumentCaptor.getValue();

        assertThat(capturedGame.getBoard()).isEqualTo(game.getBoard());
        assertThat(capturedGame.getSolution()).isEqualTo(game.getSolution());
    }
}