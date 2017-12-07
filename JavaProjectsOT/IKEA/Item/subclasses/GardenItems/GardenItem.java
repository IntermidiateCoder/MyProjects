package IKEA.Item.subclasses.GardenItems;

import IKEA.Item.Item;

public class GardenItem extends Item {
	public GardenItem(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'G');
	}
	public GardenItem(int itemID, String name, double sellPrice, double buyPrice, int num) {
		super(itemID, name, sellPrice, buyPrice, 'G', num);
	}
}
