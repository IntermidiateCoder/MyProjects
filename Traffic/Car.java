package Traffic;

public class Car {
	private int[] location;
	
	public Car() {
		this.location = new int[2];
	}
	public int[] getLocation() { return this.location;}
	public void setLocation(int numOfLine, int placeOnRoad) {
		this.location[0] = numOfLine;
		this.location[1] = placeOnRoad;
	}
	public static void drive(Road r) {
		throw new java.lang.UnsupportedOperationException();
	}
	public String toString() {
		return "Location: " + this.location[0] + "|" + this.location[1];
	}
}
