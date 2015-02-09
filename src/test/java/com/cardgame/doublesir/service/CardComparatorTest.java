package com.cardgame.doublesir.service;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Hand;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CardComparatorTest extends TestCase {

    @Test
    public void test_compare__nominal(){
        //GIVEN 
        Hand hand = new Hand();

        //WHEN
        hand.getCards().add(Card.ACE_HEART);
        hand.getCards().add(Card.FIVE_SPADE);
        hand.getCards().add(Card.ACE_CLUB);
        hand.getCards().add(Card.ACE_DIAMOND);
        hand.getCards().add(Card.EIGHT_CLUB);

        Assertions.assertThat(hand.getCards())
                .containsSequence(
                        Card.FIVE_SPADE,
                        Card.ACE_HEART,
                        Card.ACE_CLUB,
                        Card.EIGHT_CLUB,
                        Card.ACE_DIAMOND
                        );
        //THEN
    }
}