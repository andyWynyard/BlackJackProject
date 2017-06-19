package com.skilldistillery.blackjack;

import java.util.Scanner;

/**
 * This loops through the game if you 
 * would like to. However I made it so that
 * a new deck is used every time for ease.
 * @author andrewwynyard
 *
 */

public class GameDriver {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean newGame = true;
		while (newGame == true) {
			Game g1 = new Game();
			g1.play();
			System.out.print("Play again? (y/n): ");
			char choice = kb.nextLine().charAt(0);
			if (choice == 'n' || choice == 'N') {
				newGame = false;				
			
			}
		}
		kb.close();
	
	}

}
