package IKEA.Sections.subclasses;

import java.util.ArrayList;

import IKEA.CashRegister;
import IKEA.Sections.Section;
import IKEA.Worker.Worker;
import IKEA.Worker.subclasses.Cashier;

public class CashRegisterArea extends Section {
	private ArrayList<CashRegister> crs;

	public CashRegisterArea(ArrayList<CashRegister> crs, double area) {
		super(area, "Cash Register Area");
		this.crs = crs;
	}
	public CashRegisterArea(ArrayList<CashRegister> crs, double area, ArrayList<Worker> cashiers) {
		super(area, cashiers, "Cash Register Area");
		this.crs = crs;
	}
	
	public void addCashier(Cashier c) {
		this.getWorkers().add(c);
	}
	
	public void delCashier(Cashier c) {
		this.getWorkers().remove(c);
	}
	
	public ArrayList<CashRegister> getCashRegisters() {
		return crs;
	}

	public void addRegister(CashRegister cr) {
		this.crs.add(cr);
	}
	
	public void delRegister(CashRegister cr) {
		this.crs.remove(cr);
	}
}
