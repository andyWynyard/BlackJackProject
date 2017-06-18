package com.skilldistillery.blackjack;

import java.util.*;

public class Dealer {

	private int playerTotalCards = 0;
	private List<Card> deck;
	private List<Card> playerHand = new ArrayList<>();
	private List<Card> dealerHand = new ArrayList<>();
	private int numCardsInHand = 0;

	public Card addCard(List<Card> d) {
		Card c = d.get(0);
		playerTotalCards = playerTotalCards + d.get(0).getValue();
		numCardsInHand++;
		d.remove(0);
		dealerHand.add(c);
		return c;

	}

	public List<Card> getDeck() {
		return deck;
	}

	public int getPlayerTotalCards() {
		int total = 0;
		for (Card card : dealerHand) {
			total += card.getValue();
		}

		for (Card card : playerHand) {
			if (card.getRank().equals(Rank.ACE) && total > 21) {
				total -= 10;
			}
		}
		return total;
	}

	public void setPlayerTotalCards(int playerTotalCards) {
		this.playerTotalCards = playerTotalCards;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public List<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}

	public List<Card> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(List<Card> dealerHand) {
		this.dealerHand = dealerHand;
	}

	public int getNumCardsInHand() {
		return numCardsInHand;
	}

	public void setNumCardsInHand(int numCardsInHand) {
		this.numCardsInHand = numCardsInHand;
	}

}
