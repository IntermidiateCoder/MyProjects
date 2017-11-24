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
	public void convinceToVisit(String phoneNumber) { // DONE
		int oneToSeven = (int)(Math.random() * 7) + 1;
		int CONVINCED = 1;
		if(oneToSeven == CONVINCED) {
			System.out.println("A convinced customer will visit the shop soon. His phone: " + phoneNumber);
		}
	}
	public void convinceToBuy(Customer cust) {
		throw new UnsupportedOperationException();
	}

}