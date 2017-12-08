package IKEA;

import IKEA.Item.Item;
import IKEA.Sections.Section;

public class IKEAStore {
	private Section[] sections;
	private static double balance;
	public IKEAStore(Section[] s) {
		this.sections = s;
	}
	public Section[] getSections() {
		return sections;
	}
	public void setSections(Section[] sections) {
		this.sections = sections;
	}
	public static double getBalance() {
		return balance;
	}
	public static void addBalance(double amt) {
		IKEAStore.balance += amt;
	}
	public static void order(Item orderedItem) {
		orderedItem.addInStock(5);
	}
	public static void order(Item orderedItem, int amt) {
		orderedItem.addInStock(amt);
	}
}
