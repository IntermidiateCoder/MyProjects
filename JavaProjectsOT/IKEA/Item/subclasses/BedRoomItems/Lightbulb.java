package IKEA.Item.subclasses.BedRoomItems;

public class Lightbulb extends BedRoomItem{

	public Lightbulb(int itemID) {
		super(itemID, "Ligthbulb", 10, 2);
	}
	public Lightbulb(int itemID, int num) {
		super(itemID, "Ligthbulb", 10, 2, num);
	}
}
