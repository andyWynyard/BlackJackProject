package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class tests for an ace also. 
 * If an ace is present, and the player is over
 * 21, then the ace is set to 1 from 11.
 * @author andrewwynyard
 *
 */

public class Player {
	// private int handTotalVals;
	private int playerTotalCards = 0;
	private List<Card> playerHand = new ArrayList<>();
	private int numCardsInHand = 0;

	public Card addCard(List<Card> d) {
		Card c = d.get(0);
		playerTotalCards = playerTotalCards + d.get(0).getValue();
		numCardsInHand++;
		playerHand.add(c);
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
		int total = 0;
		for (Card card : playerHand) {
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
