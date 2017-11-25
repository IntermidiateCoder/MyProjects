package IKEA.Worker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Worker {
	private LocalDate startingDate;
	private String name;
	private String section;
	private double salary;
	// the rate salary increases.
	private double incRate;
	public Worker(LocalDate startingDate, String name, String section, double salary) {
		this.startingDate = startingDate;
		this.name = name;
		this.section = section;
		this.salary = salary;
		this.incRate = 1.02;
	}
	public Worker(String name, String section, double salary) {
		this.startingDate = LocalDate.now();
		this.name = name;
		this.section = section;
		this.salary = salary;
		this.incRate = 1.02;
	}
	public double getIncRate() {
		return incRate;
	}
	public void setIncRate(double incRate) {
		this.incRate = incRate;
	}
	public void requestIncreaseSalary() {
		LocalDate today = LocalDate.now();
		LocalDate startDate = this.startingDate;
		// if today's day and month are equal to the workers day and month of when he started working
		// increase his salary by the fixed increase rate.
		if(startDate.getDayOfMonth() == today.getDayOfMonth() && 
		startDate.getMonth() == today.getMonth() && 
		startDate.getYear() < today.getYear())
			setSalary(this.salary * this.incRate);
	}
	public String helpCustomer() {
		return "What do you need?";
	}
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return "Worker: " + this.name + " Starting Date: " + dtf.format(this.startingDate) + " Salary: " + this.salary  + " Section: " + this.section;
	}
}
