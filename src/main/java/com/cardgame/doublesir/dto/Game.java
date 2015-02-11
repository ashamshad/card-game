package com.cardgame.doublesir.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Game {
    private String name;
    Set<Player> players;

    public Game(String name){
        this.name = name;
        this.players = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
