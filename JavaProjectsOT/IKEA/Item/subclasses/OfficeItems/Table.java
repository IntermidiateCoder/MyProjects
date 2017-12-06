package IKEA.Item.subclasses.OfficeItems;

public class Table extends OfficeItem{
	private int width;
	private int height;
	private int length;
	private String typeOfWood;
	public Table(int itemID, int width, int height, int length, String typeOfWood) {
		super(itemID, "Table", 100, 43);
		this.width = width;
		this.height = height;
		this.length = length;
		this.typeOfWood = typeOfWood;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getLength() {
		return length;
	}
	public String getTypeOfWood() {
		return typeOfWood;
	}
}
