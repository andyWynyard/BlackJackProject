package com.skilldistillery.blackjack;

import java.util.*;


public class Game {
	private String playerHandCards = "";
	private String dealerHandCards = "";
	private int playerHandValue = 0;
	private int dealerHandValue = 0;
	
	public void play() {

	Deck d = new Deck();

		MakeAMove move = new MakeAMove();
		Scanner keyboard = new Scanner(System.in);
		int turn = 0;
		d.shuffleDeck();
		Player player = new Player();
		Dealer dealer = new Dealer();

		System.out.println("Welcome to BlackJack (insert colourful witticism about gamblers here)");

		playerHandCards = playerHandCards + ", " + player.addCard(d.getDeck());
		dealerHandCards = dealerHandCards + ", " + dealer.addCard(d.getDeck());
		playerHandValue = playerHandValue + player.getPlayerTotalCards();
		dealerHandValue = dealerHandValue + dealer.getPlayerTotalCards();
		System.out.println("You have " + playerHandCards);
		System.out.println("The dealer has " + dealerHandCards);
		turn++;		
		System.out.println(d.getDeck().size());
		
		if (move.hitOrStay().equalsIgnoreCase("HIT")) {
			playerHandCards = playerHandCards + ", " + player.addCard(d.getDeck());
			playerHandValue = playerHandValue + player.getPlayerTotalCards();
			System.out.println("You have " + playerHandCards);
			System.out.println("The dealer has " + dealerHandCards);
			turn++;		
			System.out.println(d.getDeck().size());
		} else {
			dealerHandCards = dealerHandCards + ", " + dealer.addCard(d.getDeck());
			dealerHandValue = dealerHandValue + dealer.getPlayerTotalCards();
			System.out.println("You have " + playerHandCards);
			System.out.println("The dealer has " + dealerHandCards);
			turn++;		
			System.out.println(d.getDeck().size());
		}
		

	}

	
	public void checkForTwentyOne(int playerHandValue, int dealerHandValue, String dealerHandCards, String playerHandCards) {
		if (playerHandValue == 21 && dealerHandValue == 21) {
			System.out.println("PUSH");
		} else if (playerHandValue < 21 && dealerHandValue == 21) {
			System.out.println("Dealer has BlackJack, synd om dig" + dealerHandCards);
		} else if (playerHandValue == 21 && dealerHandValue < 21) {
			System.out.println("You destroyed the dealer \"BLACKJACK\" Bra gjort!" + dealerHandCards);
		}
		
	}

}














