package IKEA;

import java.util.ArrayList;

public abstract class Hamburger {
	protected double cost;
	protected String[] components;
	protected double weight;
	public Hamburger(double cost, String[] components, double weight) {
		this.cost = cost;
		this.components = components;
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
	public String[] getComponents() {
		return components;
	}
	public void delComponents(ArrayList<String> components, String request) {
		components.remove(request);
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
