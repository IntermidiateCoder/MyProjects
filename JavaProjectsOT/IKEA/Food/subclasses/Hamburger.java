package IKEA.Food.subclasses;

import java.util.ArrayList;

import IKEA.Food.Food;

public abstract class Hamburger extends Food {
	protected double weight;
	public Hamburger(double cost, String[] components, double weight) {
		super(cost, components);
		this.weight = weight;
	}
	public Hamburger(double cost, String[] components, double weight, ArrayList<String> requests) {
		super(cost, components, requests);
		this.weight = weight;
	}
	public Hamburger(double cost, String[] components, double weight, String...requests) {
		super(cost, components, requests);
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public void cook() {
		System.out.println("cooking burgers");
	}
	@Override
	public String toString() {
		return "Hamburger [cost=" + cost + ", components=" + components + ", weight=" + weight + "]";
	}
}
