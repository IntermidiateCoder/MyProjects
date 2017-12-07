package IKEA.Item;

public class Item {
	// Item ID: first character represents the section of the item and the rest its serial number 
	private String itemID;	   
	private String name;
	private double sellPrice;
	private double buyPrice;
	protected static int inStock;
	public Item(int itemID, String name, double sellPrice, double buyPrice, char sectionID) {
		this.itemID = sectionID + Integer.toString(itemID);
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		Item.inStock = 0;
	}
	public Item(int itemID, String name, double sellPrice, double buyPrice, char sectionID, int quan) {
		this.itemID = sectionID + Integer.toString(itemID);
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		Item.inStock = quan;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public static int getInStock() {
		return inStock;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public String getItemID() {
		return itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return sellPrice;
	}
	public void setPrice(double price) {
		this.sellPrice = price;
	}
	public static void addInStock(int num) {
		Item.inStock += num;
	}
	@Override
	public String toString() {
		return this.name + " costs: " + this.sellPrice;
	}
}
