package IKEA.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import IKEA.Customer;

public class TestCustomer {
	private Customer c1;
	private Customer c2;
	private Customer c3;
	private Customer c4;
	private Customer c5;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Customer("Josh", 1250, "054-525-3681" );
		c2 = new Customer("Josh", 1250, "054-525-3681" );
		c3 = new Customer("Josh", 1250, "054-525-3681" );
		c4 = new Customer("Josh", 1250, "054-525-3681" );
		c5 = new Customer("Josh", 1250, "054-525-3681" );
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
