package casino;

public class BlackjackPlayer extends Player{

	int chips;
	
	public BlackjackPlayer(String name, int chips) {
		super(name);
		this.chips = chips;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}
	
	public boolean hasAce() {
		for (Card c : this.hand) {
			if (c.number.equals("A")) {
				return true;
			}
		} return false;
	}
	
	public int calculateTotal() {
		int total = 0;
		for (Card c : this.hand) {
			total += c.getValue();
		}
	

		//This checks for aces if over 21.
		if (total > 21 && this.hasAce()) {
			int totalWithLowAce = 0;
			for (Card c : this.hand) {
				if (c.number.equals("A")) {
					totalWithLowAce += 2;
				} else {
					totalWithLowAce += c.getValue();
				}
			}
			return totalWithLowAce;
		}
		
		return total;
	}

	public String prettyDeck() {
		String pretty = "";
		for (Card c : this.hand) {
			System.out.print(c + " ");
		}
		return pretty;
	}
	
}
