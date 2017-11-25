package IKEA;

public class BedRoomItem extends Item {
	public BedRoomItem(int itemID, String name, double sellPrice, double buyPrice, char sectionID) {
		super(itemID, name, sellPrice, buyPrice, 'B');
	}
}