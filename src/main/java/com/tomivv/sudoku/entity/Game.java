package com.tomivv.sudoku.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "board")
    private String board;
    @Column(name = "solution")
    private String solution;

    public Game() {
    }

    public Game(String name, String password, String board, String solution) {
        this.name = name;
        this.password = password;
        this.board = board;
        this.solution = solution;
    }

    public Game(long id, String name, String password, String board, String solution) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.board = board;
        this.solution = solution;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBoard() {
        return this.board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getSolution() {
        return this.solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            ", board='" + getBoard() + "'" +
            ", solution='" + getSolution() + "'" +
            "}";
    }

}
