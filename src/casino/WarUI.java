package casino;

import java.util.Scanner;

public class WarUI {

	public static void warUI() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thank you for choosing War! How many decks would you like to play with (up to 5): ");
		int choice2 = Integer.parseInt(scanner.nextLine());
		Dealer deck = new WarDealer(choice2);
		
		System.out.println("Shuffling...");
		deck.shuffle();
	
		System.out.println("Please enter a name for player one: ");
		String playerOneName = scanner.nextLine();
		Player player1 = new Player(playerOneName);
		
		System.out.println("Please enter a name for player two: ");
		String playerTwoName = scanner.nextLine();
		Player player2 = new Player(playerTwoName);
		
		Dealer.dealAllCards(deck, player1, player2);
		System.out.println(player1);
		System.out.println(player2);
		System.out.println("War is starting");
		
		War w = new War(player1, player2);
		System.out.println("the winner is: " + w.playWar());
		scanner.close();
	}
	
}
