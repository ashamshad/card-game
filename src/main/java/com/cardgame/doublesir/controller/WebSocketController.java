package com.cardgame.doublesir.controller;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Hand;
import com.cardgame.doublesir.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class WebSocketController {

  @Autowired
  CardService cardService;

  @MessageMapping("/shuffle")
  @SendTo("/topic/shuffle")
  public List<Hand> shuffleCards() {
    List<Card> cards = cardService.shuffleCards();

    List<Hand> handsFromCards = cardService.getHandsFromCards(cards);

    return handsFromCards;
  }
}