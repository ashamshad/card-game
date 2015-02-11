package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Player;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GameServiceImplTest{

    @Test(expected = IllegalArgumentException.class)
    public void test_createGame__whenGameNameNull(){
        //GIVEN
        String gameName = null;

        //WHEN
        GameService gameService = new GameServiceImpl();
        gameService.createGame(gameName);

        //THEN
        //Exception should be thrown
    }

    @Test
    public void test_createGame__nominal() {
        //GIVEN
        String game1 = "game1";
        String game2 = "game2";
        String game3 = "game3";

        //WHEN
        GameService gameService = new GameServiceImpl();
        gameService.createGame(game1);
        gameService.createGame(game2);
        gameService.createGame(game3);

        //THEN
        Assertions.assertThat(gameService.getGames().keySet())
                .hasSize(3)
                .contains(game1,
                        game2,
                        game3
                );

        Assertions.assertThat(gameService.getGames().values())
                .hasSize(3);

        Assertions.assertThat(gameService.getGames().get(game1).getName()).isEqualTo(game1);
        Assertions.assertThat(gameService.getGames().get(game2).getName()).isEqualTo(game2);
        Assertions.assertThat(gameService.getGames().get(game3).getName()).isEqualTo(game3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addPlayerToGame__whenGameDoesNotExist(){
        //GIVEN
        Player player1 = new Player();
        String game1 = "game1";

        //WHEN
        GameService gameService = new GameServiceImpl();
        gameService.addPlayerToGame(game1, player1);

        //THEN
        //Exception should be thrown
    }

    @Test
    public void test_addPlayerToGame__nominal(){
        //GIVEN
        Player player1 = new Player();
        Player player2 = new Player();
        String game1 = "game1";

        //WHEN
        GameService gameService = new GameServiceImpl();
        gameService.createGame(game1);
        gameService.addPlayerToGame(game1, player1);
        gameService.addPlayerToGame(game1, player2);

        //THEN
        Assertions.assertThat(gameService.getGames().get(game1).getPlayers())
                .contains(player1, player2);
    }
}