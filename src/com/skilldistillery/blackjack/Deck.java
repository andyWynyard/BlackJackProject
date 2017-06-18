package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;

	public Deck() {
		createDeck();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);

	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	

	public List<Card> createDeck() {
		int v = 0;
		deck = new ArrayList<Card>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				if (r.equals(Rank.TEN) || r.equals(Rank.KING) || r.equals(Rank.QUEEN) || r.equals(Rank.JACK)) {
					v = 10;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.NINE)) {
					v = 9;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.EIGHT)) {
					v = 8;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.SEVEN)) {
					v = 7;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.SIX)) {
					v = 6;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.FIVE)) {
					v = 5;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.FOUR)) {
					v = 4;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.THREE)) {
					v = 3;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.TWO)) {
					v = 2;
					deck.add(new Card(s, v, r));
				} else if (r.equals(Rank.ACE)) {
					v = 11;
					deck.add(new Card(s, v, r));
				}

			}
		}
		return deck;

		// System.out.println(deck.toString());

	}

	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}

}
