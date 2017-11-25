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
		int totalCost = 0;
		for(Item orderedItem : items) {
			totalCost += orderedItem.getPrice();
		}
		if(cust.getBalance() < totalCost) {
			System.out.println("Customer doesn't have enough money.");
		}else {
			cust.decBalance(totalCost);
		}
	}
	public void openCashRegister() {
		throw new java.lang.UnsupportedOperationException();
	}
	public void closeCashRegister() {
		throw new java.lang.UnsupportedOperationException();
	}
	public void order(Customer cust, Item...items) { // TODO. 
		throw new java.lang.UnsupportedOperationException();
	} 
}
