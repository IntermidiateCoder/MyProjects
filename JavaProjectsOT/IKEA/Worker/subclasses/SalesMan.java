package IKEA.Worker.subclasses;

import java.time.LocalDate;

import IKEA.Customer;
import IKEA.Sections.Section;
import IKEA.Worker.Worker;

public class SalesMan extends Worker {

	public SalesMan(String name, Section section) {
		super(name, section, 12500);
		this.setIncRate(1.2);
	}
	public SalesMan(LocalDate startingDate, String name, Section section) {
		super(startingDate, name, section, 12500);
		this.setIncRate(1.2);
	}
	public void convinceToVisit(String phoneNumber) { // DONE
		int oneToSeven = (int)(Math.random() * 7) + 1;
		int CONVINCED = 1;
		if(oneToSeven == CONVINCED) {
			System.out.println("A convinced customer will visit the shop soon. His phone: " + phoneNumber);
		}
	}
	public boolean convinceToBuy(Customer cust) {
		double custBalance = cust.getBalance();
		int CONVINCED = 1;
		if(custBalance >= 15000) {
			int oneToSeven = (int)(Math.random() * 7) + 1;
			if(oneToSeven == CONVINCED) {
				return true;
			}else {
				int oneToTen = (int)(Math.random() * 10) + 1;
				if(oneToTen == CONVINCED) {
					return true;
				}	
			}
		}
		return false;
	}

}