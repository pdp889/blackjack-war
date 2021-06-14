package casino;

public class WarCard extends Card {
	
	public WarCard(int value, char suit) {
		super(value, suit);
	}
	
	public WarCard(String number, char suit) {
		super(number, suit);
		if (number.equals("J")) {
			this.value = 11;
		} else if (number.equals("Q")) {
			this.value = 12;
		} else if (number.equals("K")) {
			this.value = 13;
		} else {
			this.value = 14;
		}
		
	}

	
	
}
