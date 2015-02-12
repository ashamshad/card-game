package com.cardgame.doublesir.controller;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Game;
import com.cardgame.doublesir.dto.Hand;
import com.cardgame.doublesir.service.CardService;
import com.cardgame.doublesir.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class WebSocketController {

  @Autowired
  CardService cardService;

  @Autowired
  GameService gameService;

  @MessageMapping("/shuffle")
  @SendTo("/topic/shuffle")
  public List<Hand> shuffleCards() {
    List<Card> cards = cardService.shuffleCards();

    List<Hand> handsFromCards = cardService.getHandsFromCards(cards);

    return handsFromCards;
  }


  @MessageMapping("/game")
  @SendTo("/topic/game")
  public Collection<Game> getGames() {
    Map<String, Game> games = this.gameService.getGames();

    return games.values();
  }

  @MessageMapping("/createGame")
  @SendTo("/topic/createGame")
  public String createGame(String gameName) {
    this.gameService.createGame(gameName);

    return "OK";
  }
}