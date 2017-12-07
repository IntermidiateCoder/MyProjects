package IKEA.Item.subclasses;

public class Screwdriver extends Tool{
	int screwSize;
	public Screwdriver(int itemID, int screwSize) {
		super(itemID, "Screwdriver", 6, 2);
		this.screwSize = screwSize;
	}

}
