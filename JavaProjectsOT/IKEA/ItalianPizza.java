package IKEA;

public class ItalianPizza extends Pizza{
	private static String[] components = new String[]
			{"Dough", "Tomatoes", "Cheese"};
	public ItalianPizza() {
		super(11, components, 1);
		cook();
		addComponents();
	}
	@Override
	public String toString() {
		String pizza = "";
		for(String s : ItalianPizza.components) {
			pizza += s + " ";
		}
		return pizza;
	}

}
