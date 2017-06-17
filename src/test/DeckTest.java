package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
//		deck.dealCard(d)
//			assertEquals(expected, actual);
	}

}
