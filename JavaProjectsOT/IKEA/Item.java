package IKEA;

public class Item {
	// Item ID: first character represents the section of the item and the rest its serial number 
	private String itemID;	   
	private String name;
	private double sellPrice;
	private double buyPrice;
	public Item(int itemID, String name, double sellPrice, double buyPrice, char sectionID) {
		this.itemID = sectionID + Integer.toString(itemID);
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
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
	@Override
	public String toString() {
		return this.name + " costs: " + this.sellPrice;
	}
}
