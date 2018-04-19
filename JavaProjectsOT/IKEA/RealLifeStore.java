package IKEA;

import java.util.ArrayList;

import IKEA.Item.Item;
import IKEA.Item.subclasses.BedRoomItems.Bed;
import IKEA.Item.subclasses.BedRoomItems.Lightbulb;
import IKEA.Item.subclasses.GardenItems.Pickaxe;
import IKEA.Item.subclasses.GardenItems.Shovel;
import IKEA.Item.subclasses.KitchenItems.Pan;
import IKEA.Item.subclasses.KitchenItems.Pot;
import IKEA.Item.subclasses.OfficeItems.Chair;
import IKEA.Item.subclasses.OfficeItems.Table;
import IKEA.Item.subclasses.Tools.Hammer;
import IKEA.Item.subclasses.Tools.Screwdriver;
import IKEA.Sections.Section;
import IKEA.Sections.subclasses.CashRegisterArea;
import IKEA.Sections.subclasses.ItemStoreSection;
import IKEA.Sections.subclasses.Resturant;
import IKEA.Worker.Worker;
import IKEA.Worker.subclasses.Cashier;
import IKEA.Worker.subclasses.Tutor;

public class RealLifeStore {
	public static void prepareStore() {
		Section[] s = new Section[7];
		ItemStoreSection iss1 = null;
		ItemStoreSection iss2 = null;
		ItemStoreSection iss3 = null;
		ItemStoreSection iss4 = null;
		ItemStoreSection iss5 = null;
		CashRegisterArea cra = null;
		Resturant r = null;
		ArrayList<CashRegister> crs = new ArrayList<CashRegister>();
		ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
		ArrayList<Worker> cashiers2 = new ArrayList<Worker>();
		ArrayList<Worker> workers1 = new ArrayList<Worker>();
		ArrayList<Worker> workers2 = new ArrayList<Worker>();
		ArrayList<Worker> workers3 = new ArrayList<Worker>();
		ArrayList<Worker> workers4 = new ArrayList<Worker>();
		ArrayList<Worker> workers5 = new ArrayList<Worker>();
		ArrayList<Item> bdi = new ArrayList<Item>();
		bdi.add(new Bed(2552, 20));
		bdi.add(new Lightbulb(2592, 250));
		ArrayList<Item> gi = new ArrayList<Item>();
		gi.add(new Pickaxe(1656, "Iron", 35));
		gi.add(new Shovel(1696, "Iron", 35));
		ArrayList<Item> ki = new ArrayList<Item>();
		ki.add(new Pan(1444, 12, 16, 100));
		ki.add(new Pot(1464, 6, 9, 100));
		ArrayList<Item> oi = new ArrayList<Item>();
		oi.add(new Table(1396, 35, 80, 240, "Oak Wood", 65));
		oi.add(new Chair(1397, 45, 35));
		ArrayList<Item> ti = new ArrayList<Item>();
		ti.add(new Hammer(1323, "Iron", 16, 5, 125));
		ti.add(new Screwdriver(1323, 5, 125));
		for(int i=0;i<10;i++) {
			CashRegister cr = new CashRegister(Integer.toString(1650+i));
			crs.add(cr);
			if(i%2==0) {
				cashiers.add(new Cashier("Jenya", cra, crs.get(i)));
				workers1.add(new Tutor("Roger", iss1));
				workers2.add(new Tutor("Ilan", iss2));
				workers3.add(new Tutor("Michael", iss3));
				workers4.add(new Tutor("David", iss4));
				workers5.add(new Tutor("Sirgay", iss5));
			}
			else if(i%3==0) {
				cashiers.add(new Cashier("Mualem", cra, crs.get(i)));
				workers1.add(new Tutor("Raz", iss1));
				workers2.add(new Tutor("Sahar", iss2));
				workers3.add(new Tutor("Kzizi", iss3));
				workers4.add(new Tutor("Maor", iss4));
				workers5.add(new Tutor("Sirgay", iss5));
			}
			else if(i%5==0) {
				cashiers.add(new Cashier("Senym", cra, crs.get(i)));
				workers1.add(new Tutor("Gamad", iss1));
				workers2.add(new Tutor("Gulili", iss2));
				workers3.add(new Tutor("Ofek", iss3));
				workers4.add(new Tutor("Dani", iss4));
				workers5.add(new Tutor("Daniel", iss5));
			}
			else if(i%7==0) {
				cashiers.add(new Cashier("Perez", cra, crs.get(i)));
				workers1.add(new Tutor("Samwell", iss1));
				workers2.add(new Tutor("Vlad", iss2));
				workers3.add(new Tutor("Hila", iss3));
				workers4.add(new Tutor("Eden", iss4));
				workers5.add(new Tutor("Alex", iss5));
			}
			else {
				cashiers.add(new Cashier("Miri", cra, crs.get(i)));
				workers1.add(new Tutor("Nastya", iss1));
				workers2.add(new Tutor("Pizi", iss2));
				workers3.add(new Tutor("Katya", iss3));
				workers4.add(new Tutor("Ahmed", iss4));
				workers5.add(new Tutor("Shalev", iss5));
			}
		}
		iss1 = new ItemStoreSection(6850, workers1, "Bed Room Item Section", bdi);
		iss2 = new ItemStoreSection(6850, workers2, "Garden Item Section", gi);
		iss3 = new ItemStoreSection(6850, workers3, "Kitchen Item Section", ki);
		iss4 = new ItemStoreSection(6850, workers4, "Office Item Section", oi);
		iss5 = new ItemStoreSection(6850, workers5, "Tool Item Section", ti);
		cra = new CashRegisterArea(crs, 1220);
		CashRegister cr2 = new CashRegister(Integer.toString(1450));
		Cashier c = new Cashier("Sam", r, cr2);
		cashiers2.add(c);
		r = new Resturant(680, cashiers2 , cr2);
		s[0] = iss1;
		s[1] = iss2;
		s[2] = iss3;
		s[3] = iss4;
		s[4] = iss5;
		s[5] = cra;
		s[6] = r;
		IKEAStore ikeaStore = new IKEAStore(s);
	}
	public static void main(String[] args) {
		prepareStore();
	}
}
