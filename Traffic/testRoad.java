package Traffic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testRoad {
	private Road road;
	private TrafficLight tl;
	private ArrayList<Car> cars;
	
	@Before
	public void setUp() throws Exception {
		tl = new TrafficLight(150, "North");
		cars = new ArrayList<Car>();
		Car c = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		Car c4 = new Car();
		Car c5 = new Car();
		cars.add(c);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		cars.add(c5);
		road = new Road(tl, 2, 10, cars);
	}
	
	@Test
	public void testGetOppositeDirection() {
		assertEquals(road.getOppositeDirection(road.getDirection()), "South");
	}
	@Test 
	public void testGetTimeRunning() {
		road.changeLight();
		assertEquals(road.getTimeRunning(), 0);
	}
	@Test
	public void testAddCar() {
		for(int i=0;i<cars.size();i++) {
			road.addCar(cars.get(i));
		}
		
	}

}
