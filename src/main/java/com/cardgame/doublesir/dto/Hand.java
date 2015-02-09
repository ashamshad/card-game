package com.cardgame.doublesir.dto;

import com.cardgame.doublesir.service.CardComparator;

import java.util.TreeSet;

public class Hand {
    TreeSet<Card> cards;

    public Hand(){
        this.cards = new TreeSet<>(new CardComparator());
    }

    public TreeSet<Card> getCards() {
        return cards;
    }
}
