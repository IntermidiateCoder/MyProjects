package Traffic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrafficLightTest {
	private TrafficLight tl;
	
	@Before
	public void setUp() throws Exception {
		tl = new TrafficLight(100, "West");
	}
	
	@Test
	public void testChangeLight() {
		tl.changeLight();
		assertEquals(tl.getLight(),"Green");
		tl.changeLight();
		assertEquals(tl.getLight(),"Red");
		assertEquals(tl.getTimeCounter(), 0);
	}
	
}
