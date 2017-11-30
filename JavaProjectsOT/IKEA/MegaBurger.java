package IKEA;

public class MegaBurger extends Hamburger implements Cheesy {
	private static String[] components = new String[] 
			{"Bread Bun", "Burger","Extra Thick Cheese", "Burger", "Extra Thick Cheese", "Onions", "Lettuce", "Burger", "Extra Thick Cheese", "Burger", "Extra Thick Cheese", "Onions", "Lettuce", "Bread Bun", "Large ToothPick"};
	public MegaBurger() {
		super(35.95, components, 480);
		cookBurgers();
		meltCheese();
		addComponents();
	}
	public void meltCheese() {
		System.out.println("Melting Extra Chick Cheese");	
	}
	@Override
	public String toString() {
		String burger = "";
		for(String s : components) {
			burger += s + " ";
		}
		return burger;
	}
}
