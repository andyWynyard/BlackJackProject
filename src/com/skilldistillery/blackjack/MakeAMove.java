package com.skilldistillery.blackjack;

import java.util.Scanner;

/**
 * Simple HIT or STAY method here, and I wanted
 * to make this sort of thing more common, 
 * but I ran out of time.
 * @author andrewwynyard
 *
 */

public class MakeAMove {
	Scanner keyboard = new Scanner(System.in);

	public String hitOrStay() {
		System.out.print("Would you like to hit or stay (h/s)? ");
		char choice = keyboard.next().charAt(0);
		if (choice == 'h') {
			return "HIT";
		} else {
			return "STAY";
		}

	}

}
