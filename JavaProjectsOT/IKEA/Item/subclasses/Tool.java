package IKEA.Item.subclasses;

import IKEA.Item.Item;

public class Tool extends Item {
	public Tool(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'T');
	}
	public Tool(int itemID, String name, double sellPrice, double buyPrice, int num) {
		super(itemID, name, sellPrice, buyPrice, 'T', num);
	}

}
