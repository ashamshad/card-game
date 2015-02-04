package com.cardgame.doublesir.service;


import com.cardgame.doublesir.dto.Card;
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
}