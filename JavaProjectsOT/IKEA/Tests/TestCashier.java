package IKEA.Tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import IKEA.Customer;
import IKEA.Item.subclasses.KitchenItem;
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
				LocalDate.now().getDayOfMonth()), "tamir", "000");
		c2 = new Cashier(LocalDate.of(2000, 10, 20), "Ofek", "001");
		c3 = new Cashier(LocalDate.of(2005, 9, 5), "Dani Svi", "002");
		c4 = new Cashier("Ido", "003");
		c5 = new Cashier(LocalDate.of(2019, 11, 22), "Almog", "004");
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
	}

}
