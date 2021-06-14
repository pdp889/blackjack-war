package casino;

import java.util.ArrayList;
import java.util.List;

public class Player {

	String name;
	List<Card> hand;
	
	
	/**
	 * @param name
	 *
	 */
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}

	public void addCard(Card c) {
		hand.add(c);
	}
	
	public String getName() {
		return name;
	}
	public List<Card> getCardDeck() {
		return hand;
	}

	@Override
	public String toString() {
		return name + " with an astonishing "+ hand.size() + " cards!";
	}
	
	public Card playTopCard () {
		return hand.remove(0);
	}
}
