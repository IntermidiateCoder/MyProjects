package IKEA.Worker.subclasses;

import java.time.LocalDate;

import IKEA.CashRegister;
import IKEA.Customer;
import IKEA.Item.Item;
import IKEA.Worker.Worker;

public class Cashier extends Worker {
	private CashRegister cr;
	
	public Cashier(String name, String ID, CashRegister cr) {
		super(name, "Cash Register Section", 4850);
		this.cr = cr;
		this.setIncRate(1.1);
	}
	public Cashier(LocalDate startingDate, String name, String ID, CashRegister cr) {
		super(startingDate, name, "Cash Register Section", 4850);
		this.setIncRate(1.1);
		this.cr = cr;
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
	public void charge(Customer cust, double sum) {
		this.getCashRegister().charge(cust, sum);
	}
	public void charge(Customer cust, Item...items) {
		this.getCashRegister().charge(cust, items);
	}
}
