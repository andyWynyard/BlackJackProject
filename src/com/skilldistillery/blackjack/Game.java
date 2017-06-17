package com.skilldistillery.blackjack;

public class Game {
	static Deck d = new Deck();
	public static void main(String[] args) {
		d.shuffleDeck();	
		for (Card c : d.getDeck()) {
			System.out.println(c);
		}
		
		
		d.dealCard();
		
		d.dealCard();
		
	}
	

}
