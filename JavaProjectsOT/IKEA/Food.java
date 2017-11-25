package IKEA;

import java.time.LocalDate;

public class Food {
	private String name;
	private double buyPrice;
	private LocalDate madeAt;
	private LocalDate freshUntil;
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
	public LocalDate getFreshUntil() {
		return freshUntil;
	}
	public Food(String name, double buyPrice, LocalDate madeAt, LocalDate freshUntil) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.madeAt = madeAt;
		this.freshUntil = freshUntil;
	}
	@Override
	public String toString() {
		return "Food [name = " + name + ", buyPrice = " + buyPrice + ", madeAt = " + madeAt + ", freshUntil = " + freshUntil
				+ "]";
	}
	
}
