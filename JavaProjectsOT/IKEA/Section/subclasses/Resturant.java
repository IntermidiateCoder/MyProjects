package IKEA.Section.subclasses;

import java.util.ArrayList;

import IKEA.CashRegister;
import IKEA.CheeseBurger;
import IKEA.Customer;
import IKEA.Hamburger;
import IKEA.MegaBurger;
import IKEA.Section.Section;
import IKEA.Worker.Worker;
import IKEA.Worker.subclasses.Cashier;

public class Resturant extends Section {
	private CashRegister cr;	
	public Resturant(double area, ArrayList<Worker> workers, CashRegister cr) {
		super(area, workers, "IKEA's Food Palace");
		this.cr = cr;
	}
	public Resturant(double area) {
		super(area, "IKEA's Food Palace");
	}
	public CashRegister getCr() {
		return cr;
	}
	public void setCr(CashRegister cr) {
		this.cr = cr;
	}
	public ArrayList<Hamburger> orderBurgers(Customer cust, ArrayList<String[]> order, Cashier cashier) {
		ArrayList<Hamburger> burgers = new ArrayList<Hamburger>();
		double totalCost = 0;
		for(String[] arr : order) {
			if(arr[0].equals("CheeseBurger")){
				CheeseBurger burger = null;
				ArrayList<String> requests = new ArrayList<String>();
				for(int i=1;i<arr.length;i++) {
					requests.add(arr[i]);
				}
				burger = new CheeseBurger(requests);
				burgers.add(burger);
				totalCost += burger.getCost();
			}else if(arr[0].equals("MegaBurger")) {
				MegaBurger burger = null;
				ArrayList<String> requests = new ArrayList<String>();
				for(int i=1;i<arr.length;i++) {
					requests.add(arr[i]);
				}
				burger = new MegaBurger(requests);
				burgers.add(burger);
				totalCost += burger.getCost();
			}else
				continue;
		}
		if(cust.getBalance() >= totalCost) {
			cashier.getCashRegister().charge(cust, totalCost);
			return burgers;
		}else
			return null;
	}
	public Hamburger orderBurger(Customer cust, String[] order, Cashier cashier) {
		if(order[0].equals("CheeseBurger")){
			CheeseBurger burger = null;
			ArrayList<String> requests = new ArrayList<String>();
			for(int i=1;i<order.length;i++) {
				requests.add(order[i]);
			}
			burger = new CheeseBurger(requests);
			if(cust.getBalance() >= burger.getCost()) {
				cashier.charge(cust, burger.getCost());
				return burger;
			}
		}else if(order[0].equals("MegaBurger")) {
			MegaBurger burger = null;
			ArrayList<String> requests = new ArrayList<String>();
			for(int i=1;i<order.length;i++) {
				requests.add(order[i]);
			}
			burger = new MegaBurger(requests);
			if(cust.getBalance() >= burger.getCost()) {
				cashier.charge(cust, burger.getCost());
				return burger;
			}
		}
		return null;
	}
	
}
