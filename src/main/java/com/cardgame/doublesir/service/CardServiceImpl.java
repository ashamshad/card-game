package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Hand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
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

    public List<Hand> getHandsFromCards(List<Card> cards){
        List<Hand> hands = new ArrayList<>();

        Hand hand = null;
        for (int i = 0; i < cards.size(); i++) {
            if(i % 13 == 0){
                hand = new Hand();
                hands.add(hand);
            }
            hand.getCards().add(cards.get(i));
        }

        return hands;
    }
}
