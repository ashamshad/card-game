package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Hand;

import java.util.Collection;
import java.util.List;

/**
 * Created by adilshamshad on 03/02/2015.
 */
public interface CardService {
    public List<Card> shuffleCards();

    public List<Hand> getHandsFromCards(List<Card> cards);

}
