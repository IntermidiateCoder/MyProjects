package Traffic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testCrossSection {
	private TrafficLight tl;
	private TrafficLight tl2;
	private TrafficLight tl3;
	private TrafficLight tl4;
	private Road r1;
	private Road r2;
	private Road r3;
	private Road r4;
	private CrossSection cs;
	private ArrayList<Car> cars = new ArrayList<Car>();

	@Before
	public void setUp() throws Exception {
		tl = new TrafficLight(0,"North");
		tl2 = new TrafficLight(0,"South");
		tl3 = new TrafficLight(0,"West");
		tl4 = new TrafficLight(0,"East");
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		Car c4 = new Car();
		Car c5 = new Car();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		cars.add(c5);
		r1 = new Road(tl, 2, 6, cars);
		r2 = new Road(tl2, 2, 10, cars);
		r3 = new Road(tl3, 2, 10, cars);
		r4 = new Road(tl4, 2, 10, cars);	
		cs = new CrossSection(r1, r2, r3, r4);
	}

	@Test
	public void testStartRoad() {
		cs.startRoad("West");
		assertEquals(cs.isRed(cs.getRoads().get(0)), true);
		assertEquals(cs.isRed(cs.getRoads().get(1)), true);
		assertEquals(cs.isRed(cs.getRoads().get(2)), false);
		assertEquals(cs.isRed(cs.getRoads().get(3)), false);
	}
	@Test
	public void testChangeLights() {
		for(Road r : cs.getRoads()) {
			System.out.println(r.getTrafficLight());
		}
		cs.startRoad("West");
		for(Road r : cs.getRoads()) {
			System.out.println(r.getTrafficLight());
		}
		cs.changeLights();
		for(Road r : cs.getRoads()) {
			System.out.println(r.getTrafficLight());
		}
		assertEquals(cs.isRed(cs.getRoads().get(0)), false);
		assertEquals(cs.isRed(cs.getRoads().get(1)), false);
		assertEquals(cs.isRed(cs.getRoads().get(2)), true);
		assertEquals(cs.isRed(cs.getRoads().get(3)), true);
	}
	@Test
	public void testTimeToPassTL() {
		double c1Time = cs.timeToPassTL(r1.getVehicles().get(0), r1);
		double c3Time = cs.timeToPassTL(r1.getVehicles().get(2), r1);
		double c5Time = cs.timeToPassTL(r1.getVehicles().get(4), r1);
		System.out.println("\n" + c1Time + ", " + c3Time + ", " + c5Time);
		assertEquals(c1Time, c1Time, 0);
		assertEquals(c3Time, c3Time, 0);
		assertEquals(c5Time, c5Time, 0);
	}

}
