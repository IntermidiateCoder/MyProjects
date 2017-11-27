package IKEA;

import java.time.LocalDate;

public abstract class Food {
	private String name;
	private double buyPrice;
	private LocalDate madeAt;
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getName() {
		return name;
	}
	public LocalDate getMadeAt() {
		return madeAt;
	}
	public abstract LocalDate getFreshUntil();
	
	public Food(String name, double buyPrice, LocalDate madeAt) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.madeAt = madeAt;
	}
	@Override
	public String toString() {
		return "Food [name = " + name + ", buyPrice = " + buyPrice + ", madeAt = " + madeAt + " Fresh Until: " + this.getFreshUntil() + "]";
	}
	
}
