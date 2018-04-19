package IKEA.Item.subclasses.Tools;

public class Screwdriver extends Tool{
	int screwSize;
	public Screwdriver(int itemID, int screwSize) {
		super(itemID, "Screwdriver", 6, 2);
		this.screwSize = screwSize;
	}
	public Screwdriver(int itemID, int screwSize, int num) {
		super(itemID, "Screwdriver", 6, 2, num);
		this.screwSize = screwSize;
	}

}
