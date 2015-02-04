package com.cardgame.doublesir.controller;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Hand;
import com.cardgame.doublesir.dto.Message;
import com.cardgame.doublesir.dto.OutputMessage;
import com.cardgame.doublesir.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebSocketController {

  @Autowired
  CardService cardService;

  @MessageMapping("/chat")
  @SendTo("/topic/message")
  public OutputMessage sendMessage(Message message) {

    return new OutputMessage(message, new Date());
  }

  @MessageMapping("/shuffle")
  @SendTo("/topic/shuffle")
  public List<Card> shuffleCards() {
    List<Card> hands = cardService.shuffleCards();
    return hands;
  }
}