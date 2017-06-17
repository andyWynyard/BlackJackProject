package com.skilldistillery.blackjack;

import java.util.List;

public class Hand {
	//private int handTotalVals;
	private int numCardsInHand;
	

	
	public Card addCard(List<Card> d) {
		Card c = d.get(0);
		d.remove(0);
		numCardsInHand++;
		return c;
		
	}
	public int numCardsInHand() {
		return numCardsInHand;
	}
}
