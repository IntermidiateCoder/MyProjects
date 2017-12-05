package IKEA.Food.subclasses;

import java.util.ArrayList;

public class MegaBurger extends Hamburger implements Cheesy {
	private static String[] components = new String[] 
			{"Bread Bun", "Burger","Extra Thick Cheese", "Burger", "Extra Thick Cheese", "Onions", "Lettuce", "Burger", "Extra Thick Cheese", "Burger", "Extra Thick Cheese", "Onions", "Lettuce", "Bread Bun", "Large ToothPick"};
	public MegaBurger() {
		super(35.95, components, 480);
		cook();
		meltCheese();
		addComponents();
	}
	public MegaBurger(ArrayList<String> requests) {
		super(35.95, components, 480, requests);
		cook();
		meltCheese();
		addComponents();
	}
	public MegaBurger(String...requests) {
		super(35.95, components, 480, requests);
		cook();
		meltCheese();
		addComponents();
	}
	public void meltCheese() {
		System.out.println("Melting Extra Thick Cheese");	
	}
	@Override
	public String toString() {
		String burger = "";
		for(String s : MegaBurger.components) {
			burger += s + " ";
		}
		return burger;
	}
}
