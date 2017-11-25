package IKEA.Item.subclasses;

import IKEA.Item.Item;

public class KitchenItem extends Item {

	public KitchenItem(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'K');
	}
}
