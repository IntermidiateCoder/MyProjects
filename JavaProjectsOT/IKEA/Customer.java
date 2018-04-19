package IKEA;

import java.util.ArrayList;
import java.util.regex.*;

import IKEA.Item.Item;
import IKEA.Sections.Section;
import IKEA.Worker.Worker;
import IKEA.Worker.subclasses.Tutor;

public class Customer {
	private ArrayList<Item> cart;
	private String name;
	private double balance;
	private String phoneNumber;
	
	public Customer(String name, double balance, String pn) {
		if(Customer.isPhoneNumReal(pn))
			this.setPhoneNumber(pn);
		this.name = name;
		this.balance = balance;
		this.cart = new ArrayList<Item>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	private void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public static boolean isPhoneNumReal(String phoneNumber) {
		Pattern pattern = Pattern.compile("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$");
		Matcher matcher;
		try {
			matcher = pattern.matcher(phoneNumber);
		} catch (NullPointerException e) {
			return false;
		} 
		if(matcher.matches())
			return true;
		return false;
	}
	
	public void decBalance(double totalCost) { 
		this.setBalance(this.getBalance() - totalCost);
	}
	
	public void incBalance(int amount) { 
		this.setBalance(this.getBalance() + amount);
	}
	
	public void addToCart(String itemID) {
		String prefix = "" +  itemID.charAt(0);
		for(Section s : IKEAStore.getSections()) {
			if(s.getName().startsWith(prefix)) {
				for(Worker w : s.getWorkers())
					if(w instanceof Tutor)
						cart.add(((Tutor) w).giveCustomer(itemID));
			}
		}
	
	}
	
	public void addToCart(String itemID, int amt) {
		String prefix = "" +  itemID.charAt(0);
		for(Section s : IKEAStore.getSections()) {
			if(s.getName().startsWith(prefix)) {
				for(Worker w : s.getWorkers())
					if(w instanceof Tutor)
						cart.add(((Tutor) w).giveCustomer(itemID, amt));
			}
		}
	
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", balance=" + balance + 
				", Phone number: " + this.phoneNumber + "]";
	}
}
