package casino;

import java.util.Scanner;

public class Blackjack {

	BlackjackPlayer oneP;
	BlackjackPlayer house;
	Dealer blackjackdealer;
	
	public Blackjack(BlackjackPlayer oneP, BlackjackPlayer house, int decks) {
		this.oneP = oneP;
		this.house= house;
		this.blackjackdealer = new BlackjackDealer(1);
		blackjackdealer.shuffle();

	}
	
	public int playHand(int bet) {
		oneP.addCard(blackjackdealer.dealTopCard());
		oneP.addCard(blackjackdealer.dealTopCard());
		System.out.print("Your cards: ");
		System.out.println(oneP.prettyDeck() + " -- Total: " + oneP.calculateTotal());
		
		house.addCard(blackjackdealer.dealTopCard());
		house.addCard(blackjackdealer.dealTopCard());
		System.out.println("Dealer cards: " + house.getCardDeck().get(1));
		
		int choice = 1;
		boolean bust = false;
		boolean twentyOne = false;
		if (oneP.calculateTotal() == 21) {
			twentyOne = true;
			System.out.println("Twenty-One!");
		}
		Scanner scanner1 = new Scanner(System.in);
		while(choice == 1 && twentyOne == false) {
			System.out.println("Hit or Stand? Press 1 for hit, 2 for stand.");
			choice = Integer.parseInt(scanner1.nextLine());
			
			if (choice ==1) {
				oneP.addCard(blackjackdealer.dealTopCard());
				System.out.println("Hit!");
				System.out.println("Your cards: " + oneP.prettyDeck()+ " -- Total: " + oneP.calculateTotal());
				// TODO: figure out why this prints like this.
				if (oneP.calculateTotal() > 21) {
					bust = true;
					break;
				}
			} else {
				System.out.println("Stand at " + oneP.calculateTotal());
			}
			if (oneP.calculateTotal() == 21) {
				twentyOne = true;
				System.out.println("Twenty-One!");
			}
		}
		
		if (bust == false && twentyOne == false) {
			while (house.calculateTotal() < 17 || ((house.calculateTotal() == 17) && house.hasAce())) {
				house.addCard(blackjackdealer.dealTopCard());
				System.out.println("Dealer hits");
			}
		}
		System.out.println(house.prettyDeck()+ " -- Total: " + house.calculateTotal());

		
		int playerTotal = oneP.calculateTotal();
		int houseTotal = house.calculateTotal();
		oneP.getCardDeck().clear();
		house.getCardDeck().clear();

		
		if ((playerTotal > houseTotal) && playerTotal < 22 || houseTotal > 21) {
			System.out.println(oneP.getName() + " wins " + 2*bet);
			return 2*bet;
		} else if (playerTotal == houseTotal) {
			System.out.println("push");
			return bet;
		} else {
			System.out.println(house.getName() + " wins" );
			return 0;
		}
	}
	
	
}
