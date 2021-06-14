package casino;

import java.util.ArrayList;
import java.util.List;

public class BlackjackDealer extends Dealer{

	public BlackjackDealer(int num) {
		super(num);
		for (int k=0; k<num; k++) {
			dealerDeck.addAll(createBlackjackSuit('h'));
			dealerDeck.addAll(createBlackjackSuit('d'));
			dealerDeck.addAll(createBlackjackSuit('s'));
			dealerDeck.addAll(createBlackjackSuit('c'));
		}
	}
	
	private List<Card> createBlackjackSuit(char c){
		List<Card> suit = new ArrayList<>();
		for (int i=2; i<11; i++) {
			suit.add(new BlackjackCard(i, c));
		}
		suit.add(new BlackjackCard("J", c));
		suit.add(new BlackjackCard("Q", c));
		suit.add(new BlackjackCard("K", c));
		suit.add(new BlackjackCard("A", c));
		return suit;
	}

}

