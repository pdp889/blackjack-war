package casino;

public class BlackjackCard extends Card {

	
	public BlackjackCard(int value, char suit) {
		super(value, suit);
	}
	
	public BlackjackCard(String number, char suit) {
		super(number, suit);
		if (number.equals("J")) {
			this.value = 10;
		} else if (number.equals("Q")) {
			this.value = 10;
		} else if (number.equals("K")) {
			this.value = 10;
		} else {
			this.value = 11;
		}
		
	}
	

}
	
