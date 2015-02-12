package com.cardgame.doublesir.dto;

import com.cardgame.doublesir.serializer.GameSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashSet;
import java.util.Set;

@JsonSerialize(using = GameSerializer.class)
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
