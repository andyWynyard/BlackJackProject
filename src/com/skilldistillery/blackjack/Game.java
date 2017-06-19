package com.skilldistillery.blackjack;

import java.util.*;

/**
 * This is much longer than I wanted it to be. 
 * The entire game logic is here except for checking for ace,
 * and for the player to HIT or STAY.
 * I planned on pulling much of this out and creating 
 * own classes, however I ran out of time.
 * @author andrewwynyard
 *
 */

public class Game {
	private String playerHandCards = "";
	private String dealerHandCards = "";
	private int playerHandValue = 0;
	private int dealerHandValue = 0;
	private Player player = new Player();
	private Dealer dealer = new Dealer();

	public void play() {
		
		/*New game for you to play
		sets everything up*/

		Deck d = new Deck();
		MakeAMove move = new MakeAMove();
		Scanner keyboard = new Scanner(System.in);
		d.shuffleDeck();

		System.out.println("Welcome to BlackJack");

		playerHandCards = playerHandCards + player.addCard(d.getDeck());
		dealerHandCards = dealerHandCards + dealer.addCard(d.getDeck());
		playerHandCards = playerHandCards + ", " + player.addCard(d.getDeck());
		playerHandValue = playerHandValue + player.getPlayerTotalCards();
		dealerHandValue = dealerHandValue + dealer.getPlayerTotalCards();

		System.out.println("The dealer has " + dealerHandCards + " and one other card face down.");
		dealerHandCards = dealerHandCards + ", " + dealer.addCard(d.getDeck());
		
		/*Wanted to check for initial blackjack
		You never know, and it happens often actually*/

		if (firstCheckForTwentyOne(dealerHandValue, playerHandValue, dealerHandCards, playerHandCards)) {
			System.out.println("You have:");
			for (Card card : player.getPlayerHand()) {
				System.out.println(card);
			}
			while (move.hitOrStay().equals("HIT")) {
				playerHandCards = playerHandCards + ", " + player.addCard(d.getDeck());
				playerHandValue = playerHandValue + player.getPlayerTotalCards();
				System.out.println("You have:");
				for (Card card : player.getPlayerHand()) {
					System.out.println(card);
				}

				if (player.getPlayerTotalCards() == 21) {
					System.out.println("You Win");
					System.out.println("Dealer had:");
					for (Card card : dealer.getDealerHand()) {
						System.out.println(card);
					}
					return;
				}
				if (player.getPlayerTotalCards() > 21) {
					System.out.println("You Bust");
					return;
				}

			}

			while (dealer.getPlayerTotalCards() < 17) {
				dealerHandCards = dealerHandCards + ", " + dealer.addCard(d.getDeck());
				dealerHandValue = dealerHandValue + dealer.getPlayerTotalCards();
				System.out.println("Dealer has " + dealerHandCards);
				if (dealer.getPlayerTotalCards() > 21) {
					System.out.println("Dealer Bust: you win");
					return;
				}

			}

			System.out.println("Dealer: " + dealer.getPlayerTotalCards());
			System.out.println("Player: " + player.getPlayerTotalCards());
			checkForTwentyOne(player.getPlayerTotalCards(), dealer.getPlayerTotalCards(), dealerHandCards,
					playerHandCards);
		}

		else {
			System.out.println("Game over.");
		}

	}
	//Method for first check

	public boolean firstCheckForTwentyOne(int dealerHandValue, int playerHandValue, String dealerHandCards,
			String playerHandCards) {
		if (playerHandValue == 21) {
			if (dealerHandValue == 21) {
				System.out.println("Dealer has: " + dealerHandCards);
				System.out.println("Player has: " + playerHandCards);
				System.out.println("PUSH");
				return false;
			} else {
				System.out.println("That was fast, \"BLACKJACK\"");
				System.out.println("Dealer has: " + dealerHandCards);
				System.out.println("Player has: " + playerHandCards);
				return false;
			}
		} else if (dealerHandValue == 21) {
			System.out.println("Dealer gets \"BLACKJACK\" but not you, hang your head in shame.");
			System.out.println("Dealer has: " + dealerHandCards);
			System.out.println("Player has: " + playerHandCards);
			return false;
		}
		return true;
	}
	
	/*This is the main check block for 21,
	and has a bit of Swedish in it.*/

	public boolean checkForTwentyOne(int playerHandValue, int dealerHandValue, String dealerHandCards,
			String playerHandCards) {

		if (playerHandValue == 21 && dealerHandValue == 21) {
			System.out.println("PUSH");
			return false;
		} else if (playerHandValue < 21 && dealerHandValue == 21) {
			System.out.println("Dealer has BlackJack, synd om dig!");
			return false;
		} else if (playerHandValue == 21 && dealerHandValue < 21) {
			System.out.println("You destroyed the dealer \"BLACKJACK\" Bra gjort! \nDealer had:");
			for (Card card : dealer.getDealerHand()) {
				System.out.println(card);
			}
			return false;
		} else if (playerHandValue > 21) {
			System.out.println("BUST");
			System.out.println("Dealer's cards are:");
			for (Card card : dealer.getDealerHand()) {
				System.out.println(card);
			}
			System.out.println("Your cards value is:");
			for (Card card : player.getPlayerHand()) {
				System.out.println(card);
			}
			return false;
		} else if (dealerHandValue > 21) {
			System.out.println("Dealer Busts with:");
			for (Card card : dealer.getDealerHand()) {
				System.out.println(card);
			}
			return false;
		} else if (dealerHandValue == playerHandValue) {
			System.out.println("Dealer's cards are:");
			for (Card card : dealer.getDealerHand()) {
				System.out.println(card);
			}
			System.out.println("PUSH");
			return false;
		} else if (dealerHandValue > playerHandValue) {
			System.out.println("Dealer wins with:");
			for (Card card : dealer.getDealerHand()) {
				System.out.println(card);
			}

			return false;
		} else if (dealerHandValue < playerHandValue) {
			System.out.println("You win, awesomeness!");
			return false;
		}
		return true;

	}

	public String getPlayerHandCards() {
		return playerHandCards;
	}

	public void setPlayerHandCards(String playerHandCards) {
		this.playerHandCards = playerHandCards;
	}

	public String getDealerHandCards() {
		return dealerHandCards;
	}

	public void setDealerHandCards(String dealerHandCards) {
		this.dealerHandCards = dealerHandCards;
	}

	public int getPlayerHandValue() {
		return playerHandValue;
	}

	public void setPlayerHandValue(int playerHandValue) {
		this.playerHandValue = playerHandValue;
	}

	public int getDealerHandValue() {
		return dealerHandValue;
	}

	public void setDealerHandValue(int dealerHandValue) {
		this.dealerHandValue = dealerHandValue;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

}
