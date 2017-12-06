package IKEA.Sections.subclasses;
import java.util.ArrayList;

import IKEA.Item.Item;
import IKEA.Sections.Section;
import IKEA.Worker.Worker;

public class ItemStoreSection extends Section {
	ArrayList<Item> items;

	public ItemStoreSection(double area, ArrayList<Worker> workers, String name, ArrayList<Item> items) {
		super(area, workers, name);
		this.items = items;
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public void addItems(Item...items) {
		for(Item newItem : items) {
			this.items.add(newItem);
		}
	}
	
	public void delItems(Item...items) {
		for(Item existingItem : items) {
			this.items.remove(existingItem);
		}
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
}
