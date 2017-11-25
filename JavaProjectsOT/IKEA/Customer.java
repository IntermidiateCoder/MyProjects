package IKEA;

import java.util.regex.*;


public class Customer {
	public Customer(String name, double balance, String pn) {
		if(Customer.isPhoneNumReal(pn))
			this.setPhoneNumber(pn);
		this.name = name;
		this.balance = balance;
	}
	private String name;
	private double balance;
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
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
	@Override
	public String toString() {
		return "Customer [name=" + name + ", balance=" + balance + 
				", Phone number: " + this.phoneNumber + "]";
	}
	public void decBalance(int amount) {
		this.setBalance(this.getBalance() - amount);
	}
}
