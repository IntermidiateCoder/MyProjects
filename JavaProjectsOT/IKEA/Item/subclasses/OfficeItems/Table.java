package IKEA.Item.subclasses.OfficeItems;

public class Table extends OfficeItem{
	private int width;
	private int height;
	private int length;
	private String type;
	public Table(int itemID, int width, int height, int length, String type) {
		super(itemID, "Table", 100, 43);
		this.width = width;
		this.height = height;
		this.length = length;
		this.type = type;
	}
	public Table(int itemID, int width, int height, int length, String type, int num) {
		super(itemID, "Table", 100, 43, num);
		this.width = width;
		this.height = height;
		this.length = length;
		this.type = type;
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
	public String getType() {
		return type;
	}
}
