package IKEA.Item.subclasses;

import IKEA.Item.Item;

public class OfficeItem extends Item {

	public OfficeItem(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'O');
	}
}