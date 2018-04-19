package IKEA.Worker.subclasses;
import java.time.LocalDate;

import IKEA.IKEAStore;
import IKEA.Item.Item;
import IKEA.Sections.Section;
import IKEA.Sections.subclasses.ItemStoreSection;
import IKEA.Worker.Worker;

public class Tutor extends Worker{
	public Tutor(String name, Section section) {
		super(name, section, 5300);
		this.setIncRate(1.15);
	}
	public Tutor(LocalDate startingDate, String name, Section section) {
		super(startingDate, name, section, 5300);
		this.setIncRate(1.15);
	}
	public Item giveCustomer(String itemID) {
		Item i = findItem(itemID);
		if(i == null) return null;
		if(i.getInStock() < 1)
			IKEAStore.order(i);
		return i;
	}
	public Item giveCustomer(String itemID, int amt) {
		Item i = findItem(itemID);
		if(i == null) return null;
		if(i.getInStock() < amt)
			IKEAStore.order(i, amt);
		return i;
	}
	private Item findItem(String itemID) {
		ItemStoreSection iss = (ItemStoreSection) section;
		for(Item i : iss.getItems()) 
			if(i.getItemID().equals(itemID))
				return i;
		return null;
	}
	
}
