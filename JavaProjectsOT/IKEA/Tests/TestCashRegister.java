package IKEA.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import IKEA.CashRegister;
import IKEA.Customer;
import IKEA.Item.subclasses.KitchenItems.KitchenItem;

public class TestCashRegister {
	private CashRegister c1;
	private CashRegister c2;
	private CashRegister c3;
	private CashRegister c4;
	private CashRegister c5;
	
	@Before
	public void setUp() throws Exception {
		c1 = new CashRegister("1234");
		c2 = new CashRegister("1235");
		c3 = new CashRegister("1236");
		c4 = new CashRegister("1237");
		c5 = new CashRegister("1238");
	}

	@Test
	public void testCharge() {
		Customer cust = new Customer("Josh", 1250, "0545253681" );
		Customer cust2 = new Customer("Josh", 0, "0545253681" );
		Customer cust3 = new Customer("Josh", 250, "0545253681" );
		Customer cust4 = new Customer("Josh", 1250, "0545253681" );
		Customer cust5 = new Customer("Josh", 1250, "0545253681" );
		c1.charge(cust, new KitchenItem(123456, "Sink", 1000, 900));
		c2.charge(cust2, new KitchenItem(123456, "Sink", 1000, 900));
		c3.charge(cust3, new KitchenItem(123456, "Sink", 1000, 900));
		c4.charge(cust4, new KitchenItem(123456, "Sink", 1000, 900), new KitchenItem(123456, "Sink", 1000, 900));
		c5.charge(cust5, new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9), new KitchenItem(123456, "Sink", 10, 9));
		assertEquals(cust.getBalance(), 250, 0);
		assertEquals(cust2.getBalance(), 0, 0);
		assertEquals(cust3.getBalance(), 250, 0);
		assertEquals(cust4.getBalance(), 1250, 0);
		assertEquals(cust5.getBalance(), 1090, 0);
		assertEquals(c1.getBalance(), 1000, 0);
		assertEquals(c2.getBalance(), 0, 0);
		assertEquals(c3.getBalance(), 0, 0);
		assertEquals(c4.getBalance(), 0, 0);
		assertEquals(c5.getBalance(), 160, 0);
	}

}
