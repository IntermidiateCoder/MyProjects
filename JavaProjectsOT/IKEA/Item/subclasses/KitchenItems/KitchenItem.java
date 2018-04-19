package IKEA.Item.subclasses.KitchenItems;

import IKEA.Item.Item;

public class KitchenItem extends Item {

	public KitchenItem(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'K');
	}
	public KitchenItem(int itemID, String name, double sellPrice, double buyPrice, int num) {
		super(itemID, name, sellPrice, buyPrice, 'K', num);
	}
}
