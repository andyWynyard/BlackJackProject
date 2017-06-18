package test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.skilldistillery.blackjack.Card;
import com.skilldistillery.blackjack.Deck;
import com.skilldistillery.blackjack.Rank;
import com.skilldistillery.blackjack.Suit;

public class DeckTest {

	Deck deck; 
	@Before
	public void setUp() throws Exception {
		deck = new Deck();
		
	}

	@After
	public void tearDown() throws Exception {
		deck = null;
	}

	@Test
	public void testToDealCardFromDeck() {
		deck.createDeck();
			assertEquals(52, deck.getDeck().size());
			assertTrue(deck.getDeck().get(0).getValue() < 12);
			assertFalse(deck.getDeck().get(0).getValue() < 1);
			

	}

}
