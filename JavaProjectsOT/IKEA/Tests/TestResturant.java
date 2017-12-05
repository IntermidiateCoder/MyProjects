package IKEA.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import IKEA.CheeseBurger;
import IKEA.Customer;
import IKEA.Hamburger;
import IKEA.Section.subclasses.Resturant;
import IKEA.Worker.subclasses.Cashier;

public class TestResturant {
	private Cashier c;
	private Resturant r;
	@Before
	public void setUp() throws Exception {
		c = new Cashier("Helen", "12365");
		r = new Resturant(120);
		r.getWorkers().add(c);
	}

	@Test
	public void testOrderFood() {
		Customer cust = new Customer("John", 1550, "054-852-8533");
		Hamburger resultBurger = new CheeseBurger("Lettuce");
		Hamburger burger = (Hamburger) r.orderFood(cust, new String[] {"CheeseBurger", "Lettuce"}, c);
		Hamburger resultBurger2 = new CheeseBurger("Lettuce", "Onions");
		Hamburger burger2 = (Hamburger) r.orderFood(cust, new String[] {"CheeseBurger", "Lettuce", "Onions"}, c);
		Hamburger resultBurger3 = new CheeseBurger("Lettuce", "Burger", "Cheese");
		Hamburger burger3 = (Hamburger) r.orderFood(cust, new String[] {"CheeseBurger", "Lettuce", "Cheese", "Burger"}, c);
		for(int i=0; i<burger.getMyComponents().length;i++)
			assertEquals(burger.getMyComponents()[i], resultBurger.getMyComponents()[i]);
		for(int i=0; i<burger2.getMyComponents().length;i++)
			assertEquals(burger2.getMyComponents()[i], resultBurger2.getMyComponents()[i]);
		for(int i=0; i<burger3.getMyComponents().length;i++)
			assertEquals(burger3.getMyComponents()[i], resultBurger3.getMyComponents()[i]);
	}

}
