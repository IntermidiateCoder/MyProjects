package IKEA.FoodTypes;

public abstract class Pizza extends Food{
	protected double size;
	public Pizza(double cost, String[] components, double size) {
		super(cost, components);
		this.size = size;
	}
	public double getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void cook() {
		System.out.println("cooking pizza");
	}
	@Override
	public String toString() {
		return "Pizza [cost=" + cost + ", components=" + components + ", size=" + size + "]";
	}
}
