package casino;

import java.util.Scanner;

public class BlackjackUI {

	public static void blackjackUI() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a name for player one: ");
		String playerOneName = scanner.nextLine();
		System.out.println("How many chips?");
		int chips = Integer.parseInt(scanner.nextLine());
		BlackjackPlayer player1 = new BlackjackPlayer(playerOneName, chips);
		BlackjackPlayer house = new BlackjackPlayer("House", 100000);
		Blackjack blackjackgame = new Blackjack(player1, house, 3);
		
		
		while (true) {
		System.out.println("You have " + player1.getChips() + " chips.");
		System.out.println("How much would you like to bet? Or, press -1 to leave the table");
		int bet = Integer.parseInt(scanner.nextLine());
		if (bet < 0 || ((player1.getChips() - bet) < 0)) {
			break;
		}
		player1.setChips(player1.getChips() - bet);
		int change = blackjackgame.playHand(bet);
		player1.setChips(player1.getChips() + change);
		}
		System.out.println("Leaving the table with " + player1.getChips() + " chips");
		scanner.close();
	}
}