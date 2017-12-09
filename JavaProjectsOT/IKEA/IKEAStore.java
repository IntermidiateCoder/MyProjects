package IKEA;

import IKEA.Item.Item;
import IKEA.Sections.Section;

public class IKEAStore {
	private static Section[] sections;
	private static double balance;
	public IKEAStore(Section[] s) {
		IKEAStore.sections = s;
	}
	public static Section[] getSections() {
		return sections;
	}
	public static void setSections(Section[] sections) {
		IKEAStore.sections = sections;
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
