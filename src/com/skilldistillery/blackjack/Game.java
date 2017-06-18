package com.skilldistillery.blackjack;

import java.util.*;

public class Game {
	private String playerHandCards = "";
	private String dealerHandCards = "";
	private int playerHandValue = 0;
	private int dealerHandValue = 0;
	private Player player = new Player();
	private Dealer dealer = new Dealer();

	public void play() {

		Deck d = new Deck();

		MakeAMove move = new MakeAMove();
		Scanner keyboard = new Scanner(System.in);
		d.shuffleDeck();
		// System.out.println(d.getDeck().size()); //Check to see if card total
		// is accurate
		System.out.println("Welcome to BlackJack");

		playerHandCards = playerHandCards + player.addCard(d.getDeck());
		dealerHandCards = dealerHandCards + dealer.addCard(d.getDeck());
		playerHandCards = playerHandCards + ", " + player.addCard(d.getDeck());
		playerHandValue = playerHandValue + player.getPlayerTotalCards();
		dealerHandValue = dealerHandValue + dealer.getPlayerTotalCards();
		// System.out.println("You have " + playerHandCards + " value is " +
		// playerHandValue); //Spot check
		System.out.println("The dealer has " + dealerHandCards + " and one other card face down.");
		dealerHandCards = dealerHandCards + ", " + dealer.addCard(d.getDeck());
		// System.out.println(d.getDeck().size()); // To test for cards coming
		// out of the deck.

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
				// System.out.println("Player Total: " +
				// player.getPlayerTotalCards());
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
				// System.out.println("You have " + playerHandCards + "
				// value is " + playerHandValue);
				// System.out.println("The dealer has " + dealerHandCards);
				// System.out.println(d.getDeck().size()); // To test for
				// cards coming out of the deck.
				// keyboard.close();
			}
			// for (int i = 0; i < dealerHandCards.length(); i++) {
			// if (dealer.getDealerHand()getPlayerHandCards(i))
			// }
			while (dealer.getPlayerTotalCards() < 17) {
				dealerHandCards = dealerHandCards + ", " + dealer.addCard(d.getDeck());
				dealerHandValue = dealerHandValue + dealer.getPlayerTotalCards();
				System.out.println("Dealer has " + dealerHandCards);
				if (dealer.getPlayerTotalCards() > 21) {
					System.out.println("Dealer Bust: you win");
					return;
				}

				// System.out.println("You have " + playerHandCards + "
				// value is " + playerHandValue);
				// System.out.println("The dealer has " +
				// dealerHandCards);
				// System.out.println(d.getDeck().size()); // To test
				// for cards coming out of the deck.

				// } else {
				// System.out.println("You have " + playerHandCards);
				// System.out.println("The dealer has " +
				// dealerHandCards);
			}
			// else {
			// System.out.println(dealerHandCards);
			// }
			System.out.println("Dealer: " + dealer.getPlayerTotalCards());
			System.out.println("Player: " + player.getPlayerTotalCards());
			checkForTwentyOne(player.getPlayerTotalCards(), dealer.getPlayerTotalCards(), dealerHandCards,
					playerHandCards);
		}
		// } while (checkForTwentyOne(dealerHandValue, playerHandValue,
		// dealerHandCards, playerHandCards));
		// } while (checkForTwentyOne( player.getPlayerTotalCards(),
		// dealer.getPlayerTotalCards(), dealerHandCards, playerHandCards));

		else {
			System.out.println("Game over.");
		}

	}

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
