package com.skilldistillery.blackjack;

/**
 * Simple card class. Integrated value variable
 * for assignment. Was thinking about coupling, and 
 * with the values being a variable, if a new deck is 
 * created for another type of game, 
 * different values could be passed.
 * @author andrewwynyard
 *
 */

public class Card {

	private Suit suit;
	private int value;
	private Rank rank;

	public Card(Suit suit, int value, Rank rank) {
		this.suit = suit;
		this.value = value;
		this.rank = rank;
	}

	
	@Override
	public String toString() {
		return "" + rank + " of " + suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

}
