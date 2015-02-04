package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardServiceImpl implements CardService {
    @Override
    public List<Card> shuffleCards() {
        List<Card> shuffled = new ArrayList<>();
        shuffled.addAll(Arrays.asList(Card.values()));

        Random random = new Random();
        for (int i = shuffled.size() - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);

        /* swap cards i,j */
            Card card = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, card);
        }

        return shuffled;
    }
}
