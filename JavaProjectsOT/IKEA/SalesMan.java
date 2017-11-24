package IKEA;

import java.time.LocalDate;

public class SalesMan extends Worker {

	public SalesMan(String name) {
		super(name, "Sales Department", 12500);
		this.setIncRate(1.2);
	}
	public SalesMan(LocalDate startingDate, String name) {
		super(startingDate, name, "Sales Department", 12500);
		this.setIncRate(1.2);
	}
	public void convincePotentialCustomer(String phoneNumber) { // TODO
		throw new java.lang.UnsupportedOperationException();
	}
	public void convinceCustomer(Customer cust) {
		throw new UnsupportedOperationException();
	}

}