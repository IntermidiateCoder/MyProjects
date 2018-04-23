package Traffic;

public class Old extends Passenger {

	public Old(double balance, int id, String name) {
		super(balance, id, name);
		// TODO Auto-generated constructor stub
	}
	
	public void talkToKid() {
		System.out.println("Hey kid, want a candy?");
	}
	public void askDriver() {
		System.out.println("Where am I?");
	}

}
