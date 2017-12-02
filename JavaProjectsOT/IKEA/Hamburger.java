package IKEA;

import java.util.ArrayList;

public abstract class Hamburger {
	protected double cost;
	protected static String[] components;
	protected double weight;
	public Hamburger(double cost, String[] components, double weight) {
		this.cost = cost;
		Hamburger.components = components;
	}
	public Hamburger(double cost, String[] components, double weight, ArrayList<String> requests) {
		Hamburger.components = components;
		for(String request : requests)
			delComponents(request);
		this.cost = cost;
	}
	public Hamburger(double cost, String[] components, double weight, String...requests) {
		Hamburger.components = components;
		for(String request : requests)
			delComponents(request);
		this.cost = cost;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public void delComponents(String request) {
		ArrayList<String> newBurger = new ArrayList<String>();
		if(request.equals("Burger"))
			return;
		for(String s : Hamburger.components) {
			if(!s.equals(request)) {
				newBurger.add(s);
			}
		}
		String[] newComponents = new String[newBurger.size()];
		newComponents = newBurger.toArray(newComponents);
		Hamburger.setComponents(newComponents);
	}
	public static void setComponents(String[] components) {
		Hamburger.components = components;
	}
	public void cookBurgers() {
		System.out.println("cooking burgers");
	}
	public void addComponents() {
		System.out.println("adding components");
	}
	@Override
	public String toString() {
		return "Hamburger [cost=" + cost + ", components=" + components + ", weight=" + weight + "]";
	}
}
