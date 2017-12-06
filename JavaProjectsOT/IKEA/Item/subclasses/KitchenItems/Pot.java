package IKEA.Item.subclasses.KitchenItems;

public class Pot extends KitchenItem{
	private int length;
	private int width;
	public Pot(int itemID, int length, int width) {
		super(itemID, "Pot", 14, 9);
		this.length = length;
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
}
