package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Game;
import com.cardgame.doublesir.dto.Player;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    /**
     * The games list.
     * As we don't persist the games into some database, we keep it here in cache
     */
    private Map<String, Game> games = Collections.synchronizedMap(new HashMap<>());

    /**
     * {@inheritDoc GameService.createGame}
     */
    @Override
    public void createGame(String gameName) throws IllegalArgumentException {
        if(StringUtils.isBlank(gameName)) {
            throw new IllegalArgumentException("Method createGame could not be processed. " +
                    "Parameter gameName cannot be null.");
        }

        Game game = new Game(gameName);
        games.put(gameName, game);
    }

    /**
     * {@inheritDoc GameService.addPlayerToGame}
     */
    @Override
    public void addPlayerToGame(String gameName, Player player) {
        Game game = this.getGames().get(gameName);

        if (game == null) {
            throw new IllegalArgumentException("Method addPlayerToGame could not be processed. " +
                    "The game " + gameName + "could not be found.");
        }

        game.getPlayers().add(player);
    }

    /**
     * {@inheritDoc GameService.getGames}
     */
    @Override
    public Map<String, Game> getGames() {
        return games;
    }
}
