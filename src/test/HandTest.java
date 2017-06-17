package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.Card;
import com.skilldistillery.blackjack.Hand;
import com.skilldistillery.blackjack.Rank;
import com.skilldistillery.blackjack.Suit;

public class HandTest {

	Hand hand; 
	@Before
	public void setUp() throws Exception {
		hand = new Hand();

	@After
	public void tearDown() throws Exception {
		hand = null;
	}

	@Test
	public void testToAddCardTo() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
            	int v = 0;
                deck.add(new Card(s, v, r));
            }
        }
        deck.remove(0);
        
        assertEquals(51, deck.size());
	}

}
