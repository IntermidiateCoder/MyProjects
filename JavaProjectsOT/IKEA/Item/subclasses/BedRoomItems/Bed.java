package IKEA.Item.subclasses.BedRoomItems;

public class Bed extends BedRoomItem{

	public Bed(int itemID) {
		super(itemID, "Bedroom", 300, 70);
	}
	public Bed(int itemID, int num) {
		super(itemID, "Bedroom", 300, 70, num);
	}
}
