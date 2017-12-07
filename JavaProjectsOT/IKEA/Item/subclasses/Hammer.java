package IKEA.Item.subclasses;

public class Hammer extends Tool{
	String typeOfSteel;
	int width;
	int height;
	public Hammer(int itemID, String typeOfSteel, int width, int height) {
		super(itemID, "Hammer", 13, 7);
		this.width = width;
		this.height = height;
	}

}
