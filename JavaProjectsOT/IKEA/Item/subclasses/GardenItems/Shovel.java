package IKEA.Item.subclasses.GardenItems;

public class Shovel extends GardenItem{
	private String typeOfSteel;
	public Shovel(int itemID, String typeOfSteel) {
		super(itemID, "Shovel", 5, 2);
		this.typeOfSteel = typeOfSteel;
	}
	public String getTypeOfSteel() {
		return typeOfSteel;
	}
}
