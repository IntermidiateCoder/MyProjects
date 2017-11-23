package IKEA;

public class Item {
	private String itemID;
	private String name;
	private double price;
	public Item(int itemID, String name, double price, char sectionID) {
		this.itemID = sectionID + Integer.toString(itemID);
		this.name = name;
		this.price = price;
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
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return this.name + " costs: " + this.price;
	}
}
