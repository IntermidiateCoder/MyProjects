package IKEA.Section.subclasses;

import java.util.ArrayList;

import IKEA.CashRegister;
import IKEA.Customer;
import IKEA.Food.Food;
import IKEA.Food.subclasses.CheeseBurger;
import IKEA.Food.subclasses.CrownPizza;
import IKEA.Food.subclasses.ItalianPizza;
import IKEA.Food.subclasses.MegaBurger;
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
	public ArrayList<Food> orderFood(Customer cust, ArrayList<String[]> order, Cashier cashier) {
		ArrayList<Food> foods = new ArrayList<Food>();
		double totalCost = 0;
		for(String[] arr : order) {
			if(arr[0].equals("CheeseBurger")){
				CheeseBurger burger = null;
				ArrayList<String> requests = new ArrayList<String>();
				for(int i=1;i<arr.length;i++) {
					requests.add(arr[i]);
				}
				burger = new CheeseBurger(requests);
				foods.add(burger);
				totalCost += burger.getCost();
			}else if(arr[0].equals("MegaBurger")) {
				MegaBurger burger = null;
				ArrayList<String> requests = new ArrayList<String>();
				for(int i=1;i<arr.length;i++) {
					requests.add(arr[i]);
				}
				burger = new MegaBurger(requests);
				foods.add(burger);
				totalCost += burger.getCost();
			}else if(arr[0].equals("CrownPizza")) {
				CrownPizza pizza = new CrownPizza();
				foods.add(pizza);
				totalCost += pizza.getCost();
			}else if(arr[0].equals("ItalianPizza")) {
				ItalianPizza pizza = new ItalianPizza();
				foods.add(pizza);
				totalCost += pizza.getCost();
			}else
				continue;
		} 
		if(cust.getBalance() >= totalCost) {
			cashier.getCashRegister().charge(cust, totalCost);
			return foods;
		}else
			return null;
	}
	public Food orderFood(Customer cust, String[] order, Cashier cashier) {
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
			
		}else if(order[0].equals("CrownPizza")) {
			CrownPizza pizza = new CrownPizza();
			if(cust.getBalance() >= pizza.getCost()) {
				cashier.charge(cust, pizza.getCost());
				return pizza;
			}
			
		}else if(order[0].equals("ItalianPizza")) {
			ItalianPizza pizza = new ItalianPizza();
			if(cust.getBalance() >= pizza.getCost()) {
				cashier.charge(cust, pizza.getCost());
				return pizza;
			}
			
		}
		return null;
	}
	
}
