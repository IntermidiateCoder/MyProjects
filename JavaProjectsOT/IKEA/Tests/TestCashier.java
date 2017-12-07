package IKEA.Tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import IKEA.Worker.subclasses.Cashier;

public class TestCashier {
	private Cashier c1;
	private Cashier c2;
	private Cashier c3;
	private Cashier c4;
	private Cashier c5;
	@Before
	public void setUp() throws Exception {
		c1 = new Cashier(LocalDate.of(2016, LocalDate.now().getMonth(), 
				LocalDate.now().getDayOfMonth()), "tamir", "000", null);
		c2 = new Cashier(LocalDate.of(2000, 10, 20), "Ofek", "001", null);
		c3 = new Cashier(LocalDate.of(2005, 9, 5), "Dani Svi", "002", null);
		c4 = new Cashier("Ido", "003", null);
		c5 = new Cashier(LocalDate.of(2019, 11, 22), "Almog", "004", null);
	}

	@Test
	public void testRequestIncreaseSalary() {
		c1.requestIncreaseSalary();
		c2.requestIncreaseSalary();
		c3.requestIncreaseSalary();
		c4.requestIncreaseSalary();
		c5.requestIncreaseSalary();
		assertEquals(c1.getSalary(), 5335, 0);
		assertEquals(c2.getSalary(), 4850, 0);
		assertEquals(c3.getSalary(), 4850, 0);
		assertEquals(c4.getSalary(), 4850,0);
		assertEquals(c5.getSalary(), 4850,0);
	}

}
