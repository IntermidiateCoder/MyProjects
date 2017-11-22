package IKEA.Tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import IKEA.Worker;

import java.time.LocalDate;

public class TestWorker {
	private Worker w1;
	private Worker w2;
	private Worker w3;
	private Worker w4;
	private Worker w5;
	
	@Before
	public void setUp() throws Exception{
		w1 = new Worker(LocalDate.of(2016, 11, 22), "tamir", "jimbory", 1500.00);
		w2 = new Worker(LocalDate.of(2000, 10, 20), "Ofek", "jimbory", 15.25);
		w3 = new Worker(LocalDate.of(2005, 9, 5), "Dani", "Prostitue(Hoeing) Section", 19992.505);
		w4 = new Worker("Ido", "Sales Department", 2.0);
		w5 = new Worker(LocalDate.of(2019, 11, 22), "Almog", "Pedophile Department", -50000.0);
	}
	@Test
	public void TestIncreaseSalary() {
		w1.requestIncreaseSalary();
		w2.requestIncreaseSalary();
		w3.requestIncreaseSalary();
		w4.requestIncreaseSalary();
		w5.requestIncreaseSalary();
		assertEquals(w1.getSalary(), 1530,0);
		assertEquals(w2.getSalary(), 15, 25);
		assertEquals(w3.getSalary(), 19992, 505);
		assertEquals(w4.getSalary(), 2,0);
		assertEquals(w5.getSalary(), -50000,0);
		
	}
}
