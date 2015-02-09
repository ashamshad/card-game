package com.cardgame.doublesir.dto;

import com.cardgame.doublesir.serializer.CardSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CardSerializer.class)
public enum Card {
    TWO_SPADE(2, Suit.SPADE),
    THREE_SPADE(3, Suit.SPADE),
    FOUR_SPADE(4, Suit.SPADE),
    FIVE_SPADE(5, Suit.SPADE),
    SIX_SPADE(6, Suit.SPADE),
    SEVEN_SPADE(7, Suit.SPADE),
    EIGHT_SPADE(8, Suit.SPADE),
    NINE_SPADE(9, Suit.SPADE),
    TEN_SPADE(10, Suit.SPADE),
    JACK_SPADE(11, Suit.SPADE),
    QUEEN_SPADE(12, Suit.SPADE),
    KING_SPADE(13, Suit.SPADE),
    ACE_SPADE(14, Suit.SPADE),

    TWO_CLUB(2, Suit.CLUB),
    THREE_CLUB(3, Suit.CLUB),
    FOUR_CLUB(4, Suit.CLUB),
    FIVE_CLUB(5, Suit.CLUB),
    SIX_CLUB(6, Suit.CLUB),
    SEVEN_CLUB(7, Suit.CLUB),
    EIGHT_CLUB(8, Suit.CLUB),
    NINE_CLUB(9, Suit.CLUB),
    TEN_CLUB(10, Suit.CLUB),
    JACK_CLUB(11, Suit.CLUB),
    QUEEN_CLUB(12, Suit.CLUB),
    KING_CLUB(13, Suit.CLUB),
    ACE_CLUB(14, Suit.CLUB),

    TWO_HEART(2, Suit.HEART),
    THREE_HEART(3, Suit.HEART),
    FOUR_HEART(4, Suit.HEART),
    FIVE_HEART(5, Suit.HEART),
    SIX_HEART(6, Suit.HEART),
    SEVEN_HEART(7, Suit.HEART),
    EIGHT_HEART(8, Suit.HEART),
    NINE_HEART(9, Suit.HEART),
    TEN_HEART(10, Suit.HEART),
    JACK_HEART(11, Suit.HEART),
    QUEEN_HEART(12, Suit.HEART),
    KING_HEART(13, Suit.HEART),
    ACE_HEART(14, Suit.HEART),

    TWO_DIAMOND(2, Suit.DIAMOND),
    THREE_DIAMOND(3, Suit.DIAMOND),
    FOUR_DIAMOND(4, Suit.DIAMOND),
    FIVE_DIAMOND(5, Suit.DIAMOND),
    SIX_DIAMOND(6, Suit.DIAMOND),
    SEVEN_DIAMOND(7, Suit.DIAMOND),
    EIGHT_DIAMOND(8, Suit.DIAMOND),
    NINE_DIAMOND(9, Suit.DIAMOND),
    TEN_DIAMOND(10, Suit.DIAMOND),
    JACK_DIAMOND(11, Suit.DIAMOND),
    QUEEN_DIAMOND(12, Suit.DIAMOND),
    KING_DIAMOND(13, Suit.DIAMOND),
    ACE_DIAMOND(14, Suit.DIAMOND);

    Integer mark;
    Suit suit;

    Card(int mark, Suit suit) {
        this.mark = mark;
        this.suit = suit;
    }

    public Integer getMark() {
        return mark;
    }
    public Suit getSuit() {
        return suit;
    }
}
