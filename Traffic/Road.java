package Traffic;

import java.util.ArrayList;

public class Road {
	private String direction;
	private TrafficLight tl;
	private Car[][] cars;
	private ArrayList<Car> vehicles;
	
	public Road(TrafficLight tl, int numOfLanes, int roadLength, ArrayList<Car> veh) {
		this.direction = tl.getDirection();
		this.tl = tl;
		this.cars = new Car[roadLength][numOfLanes];
		this.vehicles = new ArrayList<Car>();
		for(Car c : veh)
			this.vehicles.add(c);
		for (Car c : this.vehicles) {
			this.addCar(c);
		}

	}
	public Road(TrafficLight tl, int roadLength, ArrayList<Car> veh) {
		this.direction = tl.getDirection();
		this.tl = tl;
		this.cars = new Car[1][roadLength];
		this.vehicles = new ArrayList<Car>();
		for(Car c : veh)
			this.vehicles.add(c);
		for (Car c : this.vehicles) {
			this.addCar(c);
		}
	}
	public String getLight() {
		return this.getTrafficLight().getLight();
	}
	public void setLight(String light) { this.setLight(light);}
	public void changeLight() {
		this.getTrafficLight().changeLight();
	}
	public ArrayList<Car> getVehicles() { return this.vehicles;}
	public TrafficLight getTrafficLight() { return this.tl;}
	public String getDirection() { return this.direction;}

	public String getOppositeDirection(String direction) {
		if(direction.equals("North"))
			return "South";
		else if(direction.equals("South"))
			return "North";
		else if(direction.equals("East"))
			return "West";
		else
			return "East";
	}
	public void addCar(Car c) {
		for(int i=0;i<this.cars.length;i++) {
			for(int j=0;j<this.cars[i].length;j++) {
				if(this.cars[i][j] == null) {
					this.cars[i][j] = c;
					c.setLocation(i, j);
					System.out.println(c);
					return;
				}
				
			}
		}
	}
	public long getTimeRunning() {
		return System.currentTimeMillis() - this.getTrafficLight().getTimeCounter();
	}
	
	
}
