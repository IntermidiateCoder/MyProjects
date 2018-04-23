package War_cardGame;

public class Game {
	
	public static String war(GameBoard gb) {
		// while no one lost
		while(!gb.getP1().getDeck().getCards().isEmpty() && !gb.getP2().getDeck().getCards().isEmpty() ) {
			// each player puts a card in the fighting slot
			gb.drawCards();
			// and checks who won the brawl and adds it to their deck
			gb.play();
		}
		// when some one lost check who lost and write message according to the result
		if(gb.getP1().getDeck().getCards().isEmpty())
			return "Player 2 won with only " + gb.moves + " moves played" ;
		return "Player 1 won with only " + gb.moves + " moves played";
	}
	
	public static void main(String[] args) {
		Player p1 = new Player("Mike");
		Player p2 = new Player("James");
		GameBoard gb = new GameBoard(p1, p2);
		System.out.println(war(gb));
	}
}