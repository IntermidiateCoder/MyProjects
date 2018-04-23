package Traffic;

import java.text.MessageFormat;

public class TrafficLight {
	private double time;
	private String light;
	private String direction;
	private long timeCounter;
	
	public TrafficLight(double t, String d) {
		this.direction = d;
		this.time = t;
		this.light = "Red";
	}
	public long getTimeCounter() { return this.timeCounter;}
	public String getDirection() { return this.direction;}
	public String getLight() { return this.light;}
	public double getTime() { return this.time;}
	// sets the timer on the green light gets two arguments because I want it 
	// only to be accessed from the road class
	public void setTime(double t, Road r) { 
		this.time = t;
	}
	// changes the light to the opposite of the current light
	public void changeLight() {
		if(this.light.equals("Red")) {
			this.light = "Green";
			this.timeCounter = System.currentTimeMillis();
		}
		else {
			this.light = "Red";
			this.timeCounter = 0;
		}
	}
	public String toString() {
		return MessageFormat.format("Direction: {0}, light: {1}", this.direction, this.light); 
	}
}
