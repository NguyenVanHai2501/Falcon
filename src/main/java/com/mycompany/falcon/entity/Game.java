/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.falcon.entity;

/**
 *
 * @author hainguyen
 */
public class Game {
    private String game_id;
    private String game_name;

    public Game(String game_id, String game_name) {
        this.game_id = game_id;
        this.game_name = game_name;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id='" + game_id + '\'' +
                ", game_name='" + game_name + '\'' +
                '}';
    }
}
