package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.Card;
import com.skilldistillery.blackjack.Player;

public class PlayerTest {
	List<Card> hand = new ArrayList<>();
	Player p;
	Card c1, c2;
	@Before
	public void setUp() throws Exception {
		p = new Player();
		c1 = new Card(null, 0, null);
		c2 = new Card(null, 10, null);
		
		
	}

	@After
	public void tearDown() throws Exception {
		p = null;
		c1 = null;
		c2 = null;
	}

	@Test
	public void testForCardAdd() {
		hand.add(c1);
		hand.add(1, c2);
		
		assertEquals(0, hand.get(0).getValue());
		assertTrue(hand.get(0) != hand.get(1));
		assertFalse(hand.get(0).getValue() == hand.get(1).getValue());
		
	}
	
	@Test
	public void testForGetPlayerTotalCards() {
		hand.add(c1);
		hand.add(1, c2);
		

		assertTrue(hand.size() == 2);
		assertFalse(hand.size() == 1);

		
	}

}
