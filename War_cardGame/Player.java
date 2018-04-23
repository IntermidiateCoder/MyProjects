package War_cardGame;

public class Player {
	private String name;
	private Deck deck = new Deck();
	
	public Player(String name) {
		// I fill the player's deck and shuffle it
		this.deck.fillDeck();
		this.deck.shuffle();
		this.name = name;
	}
	public String getName() {return this.name;}
	public Deck getDeck() {return this.deck;}
	// Adds a deck to this player's deck
	public void addDeck(Deck d) {
		for(Card c: d.getCards()) {
			this.deck.getCards().add(c);
		}
		// and shuffles it
		this.deck.shuffle();
		// Setting the deck's entries to null will make it more likely
		// that the garbage collector will delete this object.
		d.delete();
	}
	// draws the top card in the deck and deletes it from the deck
	public Card drawCard() {
		if(this.deck.getSize() > 0) {
			Card card = this.deck.getCards().get(this.deck.getSize()-1);
			this.deck.getCards().remove(card);
			return card;
		}
		return null;
	}
	
	public String toString() {
		return this.name + " " + this.deck + " " + this.deck.getSize() + "Cards";
	}
}
