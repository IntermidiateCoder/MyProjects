package IKEA;

import java.time.LocalDate;

public class Cashier extends Worker {
	
	public Cashier(String name) {
		super(name, "Cash Register Section", 4850);
		this.setIncRate(1.1);
	}
	public Cashier(LocalDate startingDate, String name) {
		super(startingDate, name, "Cash Register Section", 4850);
		this.setIncRate(1.1);
	}

}
