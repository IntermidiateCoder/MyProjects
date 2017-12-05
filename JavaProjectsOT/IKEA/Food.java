package IKEA;

public abstract class Food {
	protected double cost;
	protected static String[] components;
	public Food(double cost, String[] components) {
		this.cost = cost;
		Food.components = components;
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
	
	public void setComponents(String[] components) {
		Food.components = components;
	}

	public void addComponents() {
		System.out.println("adding components");
	}
}
