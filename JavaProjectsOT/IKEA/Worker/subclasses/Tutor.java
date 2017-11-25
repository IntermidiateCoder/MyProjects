package IKEA.Worker.subclasses;
import java.time.LocalDate;

import IKEA.Worker.Worker;

public class Tutor extends Worker{
	public Tutor(String name, String section) {
		super(name, section, 5300);
		this.setIncRate(1.15);
	}
	public Tutor(LocalDate startingDate, String name, String section) {
		super(startingDate, name, section, 5300);
		this.setIncRate(1.15);
	}
	public void guideCustomer(String request) {
		throw new java.lang.UnsupportedOperationException();
	}
	
}
