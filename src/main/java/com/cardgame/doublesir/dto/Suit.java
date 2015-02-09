package com.cardgame.doublesir.dto;

public enum Suit {
    SPADE(1),
    HEART(2),
    CLUB(3),
    DIAMOND(4),;

    private Integer order;

    Suit(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }
}
