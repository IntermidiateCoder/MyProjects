package IKEA;

import java.time.LocalDate;

public class Cashier extends Worker {
	private CashRegister cr;
	
	public Cashier(String name, String ID) {
		super(name, "Cash Register Section", 4850);
		this.cr = new CashRegister(ID);
		this.setIncRate(1.1);
	}
	public Cashier(LocalDate startingDate, String name, String ID) {
		super(startingDate, name, "Cash Register Section", 4850);
		this.setIncRate(1.1);
		this.cr = new CashRegister(ID);
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
		cr.setFree(true);
	}
	public CashRegister getCashRegister() {
		return cr;
	}
	public void setCashRegister(CashRegister cr) {
		this.cr = cr;
	}
	public void closeCashRegister() {
		cr.setFree(false);
	}
	public void order(Customer cust, Item...items) { // TODO. 
		throw new java.lang.UnsupportedOperationException();
	} 
}
