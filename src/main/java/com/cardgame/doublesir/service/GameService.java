package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Game;
import com.cardgame.doublesir.dto.Player;

import java.util.List;
import java.util.Map;

/**
 * A service to manage games CRUD.
 */
public interface GameService {

    /**
     * Create a game with the given name, and adds it to the implementation games list.
     *
     * @param gameName the game name
     * @throws IllegalArgumentException
     */
    public void createGame(String gameName) throws IllegalArgumentException;

    /**
     * Adds the player to the game identified by the given name.
     *
     * @param gameName the game name
     * @param player the player to add
     */
    public void addPlayerToGame(String gameName, Player player) throws IllegalArgumentException;

    /**
     * Returns the current games list.
     *
     * @return games list
     */
    public Map<String, Game> getGames();

}
