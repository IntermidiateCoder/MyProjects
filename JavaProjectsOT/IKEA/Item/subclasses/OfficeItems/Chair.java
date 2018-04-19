package IKEA.Item.subclasses.OfficeItems;

public class Chair extends OfficeItem{
	private int height;
	private int width;
	public Chair(int itemID, int height, int width) {
		super(itemID, "Chair", 65, 32);
		this.height = height;
		this.width = width;
	}
	public Chair(int itemID, int height, int width, int num) {
		super(itemID, "Chair", 65, 32, num);
		this.height = height;
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}
