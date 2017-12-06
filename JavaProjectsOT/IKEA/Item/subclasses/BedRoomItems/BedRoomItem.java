package IKEA.Item.subclasses.BedRoomItems;

import IKEA.Item.Item;

public class BedRoomItem extends Item {
	public BedRoomItem(int itemID, String name, double sellPrice, double buyPrice) {
		super(itemID, name, sellPrice, buyPrice, 'B');
	} 
}