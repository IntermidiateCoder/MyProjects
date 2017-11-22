package IKEA.Tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import IKEA.Chef;

public class TestChef {
	private Chef c1;
	private Chef c2;
	private Chef c3;
	private Chef c4;
	private Chef c5;
	@Before
	public void setUp() throws Exception {
		c1 = new Chef(LocalDate.of(2016, 11, 22), "name1");
		c2 = new Chef(LocalDate.of(2000, 10, 20), "name2");
		c3 = new Chef(LocalDate.of(2005, 9, 5), "name3");
		c4 = new Chef("name4");
		c5 = new Chef(LocalDate.of(2019, 11, 22), "name5");
	}

	@Test
	public void test() {
		c1.requestIncreaseSalary();
		c2.requestIncreaseSalary();
		c3.requestIncreaseSalary();
		c4.requestIncreaseSalary();
		c5.requestIncreaseSalary();
		assertEquals(Math.round(c1.getSalary()), 9600, 0);
		assertEquals(c2.getSalary(), 8000, 0);
		assertEquals(c3.getSalary(), 8000, 0);
		assertEquals(c4.getSalary(), 8000,0);
		assertEquals(c5.getSalary(), 8000,0);
	}

}
