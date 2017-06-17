package com.skilldistillery.blackjack;

import java.util.Scanner;

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
