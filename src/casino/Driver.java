package casino;

import java.util.Scanner;

public class Driver {

	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome! For a War simulation, press 1. For a Blackjack game, press 2: ");
		Scanner scanner = new Scanner(System.in);
		int choice = Integer.parseInt(scanner.nextLine());;
		if (choice == 1) {
			WarUI.warUI();
		} else if (choice == 2) {
			BlackjackUI.blackjackUI();
		}
		scanner.close();
	}
}
