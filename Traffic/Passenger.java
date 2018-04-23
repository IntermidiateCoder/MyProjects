package Traffic;

//class that represents the passenger on the bus/train
public class Passenger {
	private String name;
	private double balance = 0;
	private int id;
	
	public Passenger(double balance, int id, String name) {
		this.balance = balance;
		this.id = id;
		this.balance = balance;
	}
	
	public double getBalance() {return this.balance;}
	public int getID() {return this.id;}
	public String getName() {return this.name;}
	public void setBalance(double d) { this.balance = d;}
	
	public String toString() {
		return this.getName() + " has " + this.getBalance(); 
	}
}
