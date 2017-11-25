package IKEA;

public class CashRegister {
	private double balance;
	private String ID;
	private boolean free;

	public CashRegister(double balance, String ID) {
		this.balance = balance;
		this.setID(ID);
		this.free = false;
	}
	
	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public CashRegister(String ID) {
		this.balance = 0;
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}

	private void setID(String iD) {
		ID = iD;
	}
	
	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}
	public void incBalance(double sum) {
		this.setBalance(this.getBalance() + sum);
	}
	
	@Override
	public String toString() {
		return "Cash Register ID: " + this.ID + " has " + this.balance;
	}
}
