package IKEA.FoodTypes.subclasses;

import java.util.ArrayList;

public class CheeseBurger extends Hamburger implements Cheesy{
	private static String[] components = new String[] 
			{"Bread Bun", "Burger","Cheese", "Burger", "Cheese", "Onions", "Lettuce", "Bread Bun", "Large ToothPick"};
	public CheeseBurger() {
		super(19.95, components, 240);
		cook();
		meltCheese();
		addComponents();
	}
	public CheeseBurger(ArrayList<String>requests) {
		super(19.95, components, 240, requests);
		cook();
		meltCheese();
		addComponents();
	}
	public CheeseBurger(String...requests) {
		super(19.95, components, 240, requests);
		cook();
		meltCheese();
		addComponents();
	}
	public void meltCheese() {
		System.out.println("Melting Cheese");
	}
	@Override
	public String toString() {
		String burger = "";
		for(String s : CheeseBurger.components) {
			burger += s + " ";
		}
		return burger;
	}

}
