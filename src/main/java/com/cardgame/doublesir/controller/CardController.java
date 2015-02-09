package com.cardgame.doublesir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cards")
public class CardController {

  @RequestMapping(method = RequestMethod.GET)
  public String viewCards() {
    return "cards";
  }

}