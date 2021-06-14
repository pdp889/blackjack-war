package casino;

/**
 * This class contains card objects.
 * @author Admin
 *
 */
public class Card {

	int value;
	String number;
	char suit;
	
	/**
	 * @param value
	 * @param suit
	 */
	public Card(String number, char suit) {
		this.number = number;
		this.suit = suit;
	}

	public Card(int value, char suit) {
		this.value = value;
		this.number = Integer.toString(value);
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public char getSuit() {
		return suit;
	}
	
	public String getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return "Card : " + suit + "-" + number;
	}
	
	
	
}
