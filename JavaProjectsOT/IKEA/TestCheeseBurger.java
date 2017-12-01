package IKEA;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCheeseBurger {
	private CheeseBurger cb;
	@Before
	public void setUp() throws Exception {
		cb = new CheeseBurger();
	}

	@Test
	public void testDelComponents() {
		cb.delComponents("Lettuce");
		String[] newBurger = new String[] {"Bread Bun", "Burger","Cheese", "Burger", "Cheese", "Onions", "Bread Bun", "Large ToothPick"};
		for(int i=0;i<newBurger.length;i++) {
			assertEquals(cb.getComponents()[i], newBurger[i]);
		}
	}

}
