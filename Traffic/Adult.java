package Traffic;

public class Adult extends Passenger {

	public Adult(double balance, int id, String name) {
		super(balance, id, name);
	}
	
	public void callBoss() {
		System.out.println("Hello Boss, I'll be late");
	}
	public void talkToNeigbour(Passenger p) {
		System.out.println("Hi " + p.getName() + " What a nice day today");
	}
}
