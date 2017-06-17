package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	// private int handTotalVals;
	private int playerTotalCards = 0;
	private List<Card> playerHand = new ArrayList<>();
	private int numCardsInHand = 0;

	public Card addCard(List<Card> d) {
		Card c = d.get(0);
		playerTotalCards = playerTotalCards + d.get(0).getValue();
		numCardsInHand++;
		d.remove(0);
	
		return c;

	}

	public int getNumCardsInHand() {
		return numCardsInHand;
	}

	public void setNumCardsInHand(int numCardsInHand) {
		this.numCardsInHand = numCardsInHand;
	}

	public int getPlayerTotalCards() {
		for (int i = 0; i < getNumCardsInHand(); i++) {
			
		}
		return playerTotalCards;
	}

	public void setPlayerTotalCards(int playerTotalCards) {
		this.playerTotalCards = playerTotalCards;
	}

	public List<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}

	@Override
	public String toString() {
		return "Player [playerTotalCards=" + playerTotalCards + ", playerHand=" + playerHand + "]";
	}

}
