package IKEA.Item.subclasses;

import IKEA.Item.Item;

public class GardenItem extends Item {
	public GardenItem(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'G');
	}
}