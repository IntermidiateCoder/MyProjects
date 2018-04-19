package IKEA;

import java.util.ArrayList;

import IKEA.Item.Item;

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
		IKEAStore.addBalance(sum);
	}

	public void charge(Customer cust, Item...items) { 
		double totalCost = 0;
		ArrayList<Item> cart = new ArrayList<Item>();
		for(Item orderedItem : items) {
			if(!checkInStock(orderedItem)) {
				IKEAStore.order(orderedItem);
			}
			totalCost += orderedItem.getSellPrice();
			cart.add(orderedItem);
		}
		if(cust.getBalance() < totalCost) {
			System.out.println("Customer doesn't have enough money.");
		}else {
			cust.decBalance(totalCost);
			this.incBalance(totalCost);
			for(Item i : cart)
				i.addInStock(-1);
		}
	}

	private boolean checkInStock(Item item) {
		return item.getInStock() > 0;
	}

	public void charge(Customer cust, double sum) {
		cust.decBalance(sum);
		this.incBalance(sum);
	}
	@Override
	public String toString() {
		return "Cash Register ID: " + this.ID + " has " + this.balance;
	}
}
