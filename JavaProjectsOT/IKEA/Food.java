package IKEA;

import java.util.ArrayList;

public abstract class Food {
	protected double cost;
	protected static String[] components;
	public Food(double cost, String[] components) {
		this.cost = cost;
		Food.components = components;
	}
	public Food(double cost, String[] components, ArrayList<String> requests) {
		Food.components = components;
		for(String request : requests)
			delComponents(request);
		this.cost = cost;
	}
	public Food(double cost, String[] components, String...requests) {
		Food.components = components;
		for(String request : requests)
			delComponents(request);
		this.cost = cost;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public static String[] getComponents() {
		return components;
	}
	public abstract void delComponents(String request);
	
	public static void setComponents(String[] components) {
		Hamburger.components = components;
	}
	public abstract void cook();

	public void addComponents() {
		System.out.println("adding components");
	}
}
