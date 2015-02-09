package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Hand;
import org.assertj.core.api.Condition;

public class HandCondition extends Condition<Hand> {
    @Override
    public boolean matches(Hand hand) {
        return hand.getCards().size() == 13;
    }
}
