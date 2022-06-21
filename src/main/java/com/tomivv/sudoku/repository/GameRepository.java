package com.tomivv.sudoku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomivv.sudoku.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
