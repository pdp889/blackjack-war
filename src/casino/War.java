package casino;

import java.util.ArrayList;
import java.util.List;

public class War {

	Player oneP;
	Player twoP;
	List<Card> warDeck;
	int count;
	
	
	public War (Player oneP, Player twoP) {
		this.oneP = oneP;
		this.twoP = twoP;
		this.warDeck = new ArrayList<>();
		this.count = 0;
	}
	
	public Player playWar() {
		
		while (oneP.hand.size() > 0 && twoP.hand.size() > 0) {

			count +=1;
			
			Card cardOne = oneP.playTopCard();
			Card cardTwo = twoP.playTopCard();
			
			//This section will output the two cards played, as well as show the number of cards remaining.
			System.out.println("Round " + count);
			System.out.println(oneP.getName() + " plays " + cardOne + "! He/She has " + oneP.hand.size() + " cards left!");
			System.out.println(twoP.getName() + " plays " + cardTwo + "! He/She has " + twoP.hand.size() + " cards left!\n");
			
			
			
			if (cardOne.getValue() > cardTwo.getValue())  {
				oneP.addCard(cardOne);
				oneP.addCard(cardTwo);
				oneP.getCardDeck().addAll(warDeck);
				warDeck.clear();
				System.out.println(oneP.getName() + " wins this round!");
			} else if (cardTwo.getValue() > cardOne.getValue()) {
				twoP.addCard(cardTwo);
				twoP.addCard(cardOne);
				twoP.getCardDeck().addAll(warDeck);
				warDeck.clear();
				System.out.println(twoP.getName()+ " wins this round!");
			} else {
				if ((oneP.hand.size() < 4) || (twoP.hand.size() < 4)) {
					break;
				}
				System.out.println("War!");
				warDeck.add(cardOne);
				warDeck.add(cardTwo);
				warDeck.add(oneP.playTopCard());
				warDeck.add(oneP.playTopCard());
				warDeck.add(oneP.playTopCard());
				warDeck.add(twoP.playTopCard());
				warDeck.add(twoP.playTopCard());
				warDeck.add(twoP.playTopCard());
				playWar();
			}
		}
		if (oneP.hand.size()<twoP.hand.size()) {
			return twoP;
		} else {
			return oneP;
		}
	}
}
