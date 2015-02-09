package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Suit;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        int compare;
        if(o1 != null && o2 != null) {
            Suit suit1 = o1.getSuit();
            Suit suit2 = o2.getSuit();
            compare = suit1.getOrder().compareTo(suit2.getOrder());
            if (compare == 0) {
                compare = -(o1.getMark().compareTo(o2.getMark()));
            }
        } else if (o1 == null) {
            compare = 1;
        } else {
            compare = -1;
        }
        return compare;
    }
}
