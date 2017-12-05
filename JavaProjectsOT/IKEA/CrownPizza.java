package IKEA;

public class CrownPizza extends Pizza{
	private static String[] components = new String[]
			{"Crown Dough", "Tomatoes", "Cheese"};
	public CrownPizza() {
		super(15, components, 1);
		cook();
		addComponents();
	}
	@Override
	public String toString() {
		String pizza = "";
		for(String s : CrownPizza.components) {
			pizza += s + " ";
		}
		return pizza;
	}

}
