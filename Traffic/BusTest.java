package Traffic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusTest {
	private Kid k;
	private Old o;
	private Bus b;
	
	@Before
	public void setUp() throws Exception {
		k = new Kid(20, 123456, "Bobby");
		o = new Old(2.36, 147896, "Avi");
		b = new Bus(120);
	}
	
	@Test
	public void testAddPassenger() {
		b.addPassenger(k);
		b.addPassenger(o);
		assertEquals(b.getOnBoard(), 1);
	}

}
