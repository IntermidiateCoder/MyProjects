package IKEA.Item.subclasses.GardenItems;

public class Pickaxe extends GardenItem{
	private String typeOfSteel;
	public Pickaxe(int itemID, String typeOfSteel) {
		super(itemID, "Pickaxe", 8, 3);
		this.typeOfSteel = typeOfSteel;
	}
	public String getTypeOfSteel() {
		return typeOfSteel;
	}

}
