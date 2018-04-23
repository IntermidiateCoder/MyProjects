package Traffic;

import java.util.ArrayList;

public class Bus extends Car{
	private ArrayList<Passenger> passengers; 
	private ChargeMachine cm;
	
	public Bus(double b) {
		super();
		this.cm = new ChargeMachine(b);
		this.passengers = new ArrayList<Passenger>();
		
	}
	public int getOnBoard() { return this.passengers.size();}
	public ChargeMachine getCM() { return this.cm;}
	public void addPassenger(Passenger p) {
		if(cm.Charge(p))
			passengers.add(p);
	}
}
