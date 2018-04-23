package Traffic;

import java.util.ArrayList;

public class CrossSection {
	private ArrayList<Road> roads;
	
	public CrossSection(Road...args) {
		this.roads = new ArrayList<Road>();
		for(Road road : args)
			this.roads.add(road);
	}
	public CrossSection(int numOfLanes, int roadLength, Road...args) {
		this.roads = new ArrayList<Road>();
		for(Road road : args)
			this.roads.add(road);
	}
	public ArrayList<Road> getRoads() { return this.roads;}
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
	public void startRoad(String direction) { 
		for(Road road : this.roads) {
			if(direction.equals(road.getDirection()) || 
					getOppositeDirection(direction).equals(road.getDirection()))
				road.getTrafficLight().changeLight();
		}
	}
	public void changeLights() {
		int sum = 0;
		for(Road road : this.roads) {
			if(isRed(road) && !isRed(diagonalRoad(road)) && timeOff(diagonalRoad(road))) {
				sum++;
				road.changeLight();
				diagonalRoad(road).changeLight();	
				if(sum == 2)
					break;
			}		
		}
	}
	private boolean timeOff(Road road) {
		if(!isRed(road) && road.getTrafficLight().getTime() 
				<= road.getTimeRunning())
			return true;
		return false;
	}
	public Road diagonalRoad(Road road) {
		for(Road r : this.roads) {
			if(!isRed(r) && !road.getDirection().equals(r.getDirection()) && !road.getDirection().equals
					(r.getOppositeDirection(r.getDirection())))
					return r;
		}
		return null;
	}
	public Road diagonalRoad2(Road road) {
		for(Road r : this.roads) {
			if(!road.getDirection().equals(r.getDirection()) && !road.getDirection().equals
					(r.getOppositeDirection(r.getDirection())))
					return r;
		}
		return null;
	}
	public boolean isRed(Road road) {
		if(road.getLight().equals("Red"))
			return true;
		return false;
	}
	public double timeToPassTL(Car c, Road r) {
		double diagrGreenTime = this.diagonalRoad2(r).getTrafficLight().getTime();
		double halfrGreenTime = r.getTrafficLight().getTime() / 2;
		double numOfCyclesToPass = c.getLocation()[1] / halfrGreenTime > 1 ? diagrGreenTime : 0;
		
		return  diagrGreenTime - this.diagonalRoad2(r).getTimeRunning() + 
				halfrGreenTime * 2 * c.getLocation()[1] / halfrGreenTime
				+ numOfCyclesToPass;
	}
}
