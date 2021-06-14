package casino;

import java.util.ArrayList;
import java.util.List;

public class WarDealer extends Dealer{

	public WarDealer(int num) {
		super(num);
		for (int k=0; k<num; k++) {
			dealerDeck.addAll(createWarSuit('h'));
			dealerDeck.addAll(createWarSuit('d'));
			dealerDeck.addAll(createWarSuit('s'));
			dealerDeck.addAll(createWarSuit('c'));
		}
	}
	
	private List<Card> createWarSuit(char c){
		List<Card> suit = new ArrayList<>();
		for (int i=2; i<11; i++) {
			suit.add(new WarCard(i, c));
		}
		suit.add(new WarCard("J", c));
		suit.add(new WarCard("Q", c));
		suit.add(new WarCard("K", c));
		suit.add(new WarCard("A", c));
		return suit;
	}

}
