package com.cardgame.doublesir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/createGame")
public class CreateGameController {

  @RequestMapping(method = RequestMethod.GET)
  public String createGame() {
    return "createGame";
  }

}