package IKEA.Item.subclasses.KitchenItems;

public class Pan extends KitchenItem{
	private int length;
	private int width;
	public Pan(int itemID, int length, int width) {
		super(itemID, "Pan", 15, 7);
		this.length = length;
		this.width = width;
	}
	public Pan(int itemID, int length, int width, int num) {
		super(itemID, "Pan", 15, 7, num);
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
