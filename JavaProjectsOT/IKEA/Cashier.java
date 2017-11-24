package IKEA;

import java.time.LocalDate;

public class Cashier extends Worker {
	
	public Cashier(String name) {
		super(name, "Cash Register Section", 4850);
		this.setIncRate(1.1);
	}
	public Cashier(LocalDate startingDate, String name) {
		super(startingDate, name, "Cash Register Section", 4850);
		this.setIncRate(1.1);
	}
	public void charge(Customer cust, Item...items) {
		throw new java.lang.UnsupportedOperationException();
	}
	public void openCashRegister() {
		throw new java.lang.UnsupportedOperationException();
	}
	public void closeCashRegister() {
		throw new java.lang.UnsupportedOperationException();
	}
	public void order(Customer cust, Item...items) { // DONE
		for(Item orderedItem : items) {
			cust.setBalance(cust.getBalance() - orderedItem.getPrice());
		}
	} 
}
