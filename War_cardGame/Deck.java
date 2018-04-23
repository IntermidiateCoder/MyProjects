package War_cardGame;

import java.util.ArrayList;

public class Deck implements Card_types {
	// this Arraylist will hold all the cards
	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	public ArrayList<Card> getCards() {return cards;}
	public int getSize() {return this.getCards().size();}
	// Fills the deck with 52 cards of every suit+rank
	public void fillDeck() {
		for (Suit s : Suit.values()) {
		    for (Rank r : Rank.values()) {
		        cards.add(new Card(r,s));
		    }
		}
	}
	// Shuffles the deck randomly
	public void shuffle() {
		for(int i=0; i<this.cards.size(); i++) {
			int rand = (int) (Math.random() * this.cards.size());
			Card temp = this.cards.get(rand);
			this.cards.set(rand, this.cards.get(i));
			this.cards.set(i, temp);
		}
	} 
	// returns the value of the top card in the deck
	public Card drawCardD() {
		return this.getCards().get(getSize()-1);
	}
	// deletes the deck
	public void delete() {
		this.cards.clear();
	}
	// adds 2 decks into 1 different deck
	public Deck addDecks(Deck d) {
		Deck deck = new Deck();
		for(Card c: d.getCards()) {
			deck.getCards().add(c);
		}
		for(Card c: this.getCards()) {
			deck.getCards().add(c);
		}
		// Empties the decks
		this.delete();
		d.delete();
		return deck;
	}
	
	public String toString() {
		return this.cards.toString();
	}
}
