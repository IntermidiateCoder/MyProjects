package IKEA;

import java.util.ArrayList;

public abstract class Pizza extends Food{
	protected double size;
	public Pizza(double cost, String[] components, double size) {
		super(cost, components);
		this.size = size;
	}
	public Pizza(double cost, String[] components, double size, ArrayList<String> requests) {
		super(cost, components, requests);
		this.size = size;
	}
	public Pizza(double cost, String[] components, double size, String...requests) {
		super(cost, components, requests);
		this.size = size;
	}
	public double getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void delComponents(String request) {
		ArrayList<String> newPizza = new ArrayList<String>();
		if(request.equals("Pizza"))
			return;
		for(String s : Pizza.components) {
			if(!s.equals(request)) {
				newPizza.add(s);
			}
		}
		String[] newComponents = new String[newPizza.size()];
		newComponents = newPizza.toArray(newComponents);
		Pizza.setComponents(newComponents);
	}
	public void cook() {
		System.out.println("cooking pizza");
	}
	@Override
	public String toString() {
		return "Pizza [cost=" + cost + ", components=" + components + ", size=" + size + "]";
	}
}
