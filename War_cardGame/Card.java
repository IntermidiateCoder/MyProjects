package War_cardGame;

public class Card implements Card_types {
	
	private Rank num;
	private Suit type;
	
	public Card(Rank num, Suit type) {
		this.num = num;
		this.type = type;
	}
	public Rank getNum() {return this.num;}
	// Compares two cards and returns the bigger card 
	public Card compare(Card c) {
		if(this.num.value < c.getNum().value)
			return c;
		return this;
	}
	
	public String toString() {
		return this.num + " " + this.type; 
	}
}
