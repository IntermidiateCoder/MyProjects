package Traffic;

public class ChargeMachine {
	private double balance = 0;
	
	public ChargeMachine(double bal) {
		this.setBalance(bal);
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean chargeKid(Kid k) {
		if(k.getBalance() > 5.98) {
			k.setBalance(k.getBalance() - 5.99);
			System.out.println("new balance is " + k.getBalance());
			return true;
		}
		return false;
	}
	public boolean chargeAdult(Adult a) {
		if(a.getBalance() > 9.98) {
			a.setBalance(a.getBalance() - 9.99);
			System.out.println("new balance is " + a.getBalance());
			return true;
		}
		return false;
	}
	public boolean chargeOld(Old o) {
		if(o.getBalance() > 5.98) {
			o.setBalance(o.getBalance() - 5.99);
			System.out.println("new balance is " + o.getBalance());
			return true;
		}
		return false;
	}
	
	public boolean Charge(Passenger p) {
		if(p.getClass() == Kid.class) {
			Kid k = (Kid) p;
			if(chargeKid(k))
				return true;
		}
		else if(p.getClass() == Adult.class) {
			Adult a = (Adult) p;
			if(chargeAdult(a))
				return true;
		}
		else {
			Old o = (Old) p;
			if(chargeOld(o))
				return true;
		}
		return false;
			
	}
}
