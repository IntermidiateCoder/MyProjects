package War_cardGame;

public class GameBoard {
	// this variable counts how many moves were played
	public int moves = 0;
	private Player player1;
	private Player player2;
	// Empty places for each player to stack cards on while brawling
	private Deck d1 = new Deck();
	private Deck d2 = new Deck();
	
	public GameBoard(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;	
	}
	public Player getP1() {return this.player1;}
	public Player getP2() {return this.player2;}
	
	// puts the top card of each players deck in the fighting slots(decks)
	public void drawCards() {
		moves++;
		this.d1.getCards().add(player1.drawCard());
		this.d2.getCards().add(player2.drawCard());
	}
	
	public void play() {
		// Initializes the top card into a variable
		Card c1 = this.d1.drawCardD();
		Card c2 = this.d2.drawCardD();
		// checks that no one lost yet
		if(!this.player1.getDeck().getCards().isEmpty() && !this.player2.getDeck().getCards().isEmpty()) {
			// checks if the values of the cards are equal
			if(c1.getNum().value == c2.getNum().value) {
				// if they are each player draws new cards
				this.drawCards();
				// and repeat the process
				this.play();
			}
			// if they aren't equal checks who is bigger and adds the cards in the 2 
			// fighting slots to the winner's deck
			else if((c1.compare(c2)).equals(c1)) {
				this.player1.addDeck(this.d1.addDecks(this.d2));
			
				System.out.println("Player 1 won this brawl " + "p1 has: " + 
						this.player1.getDeck().getSize() + " cards left p2 has: " + 
						this.player2.getDeck().getSize() + " cards left\n");
			}
			else {
				this.player2.addDeck(this.d1.addDecks(this.d2));
			
				System.out.println("Player 2 won this brawl " + "p1 has: " + 
						this.player1.getDeck().getSize() + " cards left p2 has: " + 
						this.player2.getDeck().getSize() + " cards left\n");
			}
		}
		
	}
		
}
