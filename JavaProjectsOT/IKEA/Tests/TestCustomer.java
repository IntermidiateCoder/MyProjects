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
		c1 = new Customer("Josh", 1250, "0545253681" );
		c2 = new Customer("Josh", 1250, "054-525-3681" );
		c3 = new Customer("Josh", 1250, "054515-3681" );
		c4 = new Customer("Josh", 1250, "A54-525-3681" );
		c5 = new Customer("Josh", 1250, "054-52536981" );
	}

	@Test
	public void testIsPhoneNumReal() {
		assertEquals(Customer.isPhoneNumReal(c1.getPhoneNumber()), true);
		assertEquals(Customer.isPhoneNumReal(c2.getPhoneNumber()), true);
		assertEquals(Customer.isPhoneNumReal(c3.getPhoneNumber()), true);
		assertFalse(Customer.isPhoneNumReal(c4.getPhoneNumber()));
		assertFalse(Customer.isPhoneNumReal(c5.getPhoneNumber()));
		assertFalse(Customer.isPhoneNumReal("aswfafa"));
		assertFalse(Customer.isPhoneNumReal("123456789"));
		assertFalse(Customer.isPhoneNumReal("052-676a4432"));
	}

}
