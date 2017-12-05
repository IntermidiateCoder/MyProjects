package IKEA;

import java.util.ArrayList;

public abstract class Hamburger extends Food {
	protected double weight;
	protected String[] myComponents = Hamburger.components;
	public Hamburger(double cost, String[] components, double weight) {
		super(cost, components);
		this.weight = weight;
	}
	public Hamburger(double cost, String[] components, double weight, ArrayList<String> requests) {
		super(cost, components);
		for(String request : requests)
			this.myComponents = delComponents(request);
		this.weight = weight;
	}
	public Hamburger(double cost, String[] components, double weight, String...requests) {
		super(cost, components);
		for(String request : requests)
			this.myComponents = delComponents(request);
		this.weight = weight;
	}
	public String[] getMyComponents() {
		return myComponents;
	}
	public void setMyComponents(String[] myComponents) {
		this.myComponents = myComponents;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String[] delComponents(String request) {
		ArrayList<String> newBurger = new ArrayList<String>();
		if(request.equals("Burger"))
			return this.myComponents;
		for(String s : Hamburger.components) {
			if(!s.equals(request)) {
				newBurger.add(s);
			}
		}
		String[] newComponents = new String[newBurger.size()];
		newComponents = newBurger.toArray(newComponents);
		return newComponents;
	}
	public void cook() {
		System.out.println("cooking burgers");
	}
	@Override
	public String toString() {
		return "Hamburger [cost=" + cost + ", components=" + myComponents + ", weight=" + weight + "]";
	}
}
