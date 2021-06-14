package casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {

	List<Card> dealerDeck;
	int numberDecks;
	

	/**
	 * @param numberDecks
	 */
	public Dealer(int num) {
		this.dealerDeck = new ArrayList<>();
		this.numberDecks = num;
	}
	
	public List<Card> getDealerDeck() {
		return dealerDeck;
	}

	public int getNumberDecks() {
		return numberDecks;
	}

	
	public void shuffle() {
		Collections.shuffle(dealerDeck);
	}

	@Override
	public String toString() {
		String cardList ="";
		for (Card c : dealerDeck) {
			cardList += c +"\n";
		}
		return cardList;
	}
	
	public Card dealTopCard() {
		return dealerDeck.remove(0);
	}
	
		public static void dealAllCards(Dealer deck, Player ...players) {
		
		while (deck.getDealerDeck().size() >= players.length) {
			for (Player p : players) {
				p.addCard(deck.dealTopCard());
			}
		} 
		int remaining = deck.getDealerDeck().size();
		for (int i = 0; i < remaining; i++) {
			players[i].addCard(deck.dealTopCard());
		}
	}
}