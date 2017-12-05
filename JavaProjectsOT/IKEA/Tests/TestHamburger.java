package IKEA.Tests;


import org.junit.Before;
import org.junit.Test;

import IKEA.CheeseBurger;
import IKEA.MegaBurger;

public class TestHamburger {
	private CheeseBurger b1;
	private CheeseBurger b2;
	private MegaBurger b3;
	private MegaBurger b4;
	
	@Before
	public void setUp() throws Exception {
		b1 = new CheeseBurger();
		b2 = new CheeseBurger(new String[] {"No sauce", "Banana"});
		b3 = new MegaBurger();
		b4 = new MegaBurger(new String[] {"No sauce", "Banana"});
	}

	@Test
	public void testRequestIncreaseSalary() {
		b1.cook();
		System.out.print(b1.toString());

		b2.cook();
		System.out.print(b2.toString());
		
		b3.cook();
		System.out.print(b1.toString());

		b4.cook();
		System.out.print(b2.toString());
	}

}
