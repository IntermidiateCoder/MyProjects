package IKEA;

public class Customer {
	public Customer(String name, double balance, String pn) {
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
	public boolean isPhoneNumReal(String phoneNumber) {
		throw new java.lang.UnsupportedOperationException();
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", balance=" + balance + 
				", Phone number: " + this.phoneNumber + "]";
	}
}
