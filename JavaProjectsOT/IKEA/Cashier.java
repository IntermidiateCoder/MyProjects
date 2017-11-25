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
	public void charge(Customer cust, Item...items) { // DONE
			for(Item orderedItem : items) {
				cust.setBalance(cust.getBalance() - orderedItem.getPrice());
				this.getCashRegister().incBalance(orderedItem.getPrice());
			}
	}
	public CashRegister openCashRegister() {
		throw new java.lang.UnsupportedOperationException();
	}
	public CashRegister getCashRegister() {
		return cr;
	}
	public void setCashRegister(CashRegister cr) {
		this.cr = cr;
	}
	public void closeCashRegister() {
		throw new java.lang.UnsupportedOperationException();
	}
	public void order(Customer cust, Item...items) { // TODO. 
		throw new java.lang.UnsupportedOperationException();
	} 
}
