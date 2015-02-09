package com.cardgame.doublesir.service;


import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Hand;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardServiceImplTest {

    @Before
    public void setupDeck(){
        List<Card> shuffled = new ArrayList<>();
        shuffled.addAll(Arrays.asList(Card.values()));
    }

    @Test
    public void test_shuffleCards__whenReturnShuffledCards(){
        //GIVEN
        CardService cardService = new CardServiceImpl();

        //WHEN
        List<Card> shuffleCards = cardService.shuffleCards();

        //THEN
        Assert.assertEquals(shuffleCards.size(), 52);
    }

    @Test
    public void test_getHandsFromCards__nominal(){
        //GIVEN
        CardService cardService = new CardServiceImpl();
        List<Card> shuffleCards = cardService.shuffleCards();

        //WHEN
        List<Hand> hands = cardService.getHandsFromCards(shuffleCards);

        //THEN
        Condition<Hand> condition = new HandCondition();

        Assertions.assertThat(shuffleCards).isNotNull();
        Assertions.assertThat(hands)
                .isNotNull()
                .areExactly(4, condition);
    }
}