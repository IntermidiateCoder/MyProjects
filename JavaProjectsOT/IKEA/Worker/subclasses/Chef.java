package IKEA.Worker.subclasses;
import java.time.LocalDate;

import IKEA.Worker.Worker;

public class Chef extends Worker{
	public Chef(String name) {
		super(name, "Fast Food Restaurant", 8000);
		this.setIncRate(1.2);
	}
	public Chef(LocalDate startingDate, String name) {
		super(startingDate, name, "Fast Food Restaurant", 8000);
		this.setIncRate(1.2);
	}
	
}
