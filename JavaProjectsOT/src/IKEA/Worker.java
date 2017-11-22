package IKEA;
import java.util.Date;
public class Worker {
	private Date startingDate;
	private String name;
	private String section;
	private double salary;
	public Worker(Date startingDate, String name, String section, double salary) {
		this.startingDate = startingDate;
		this.name = name;
		this.section = section;
		this.salary = salary;
	}
	public void increaseSalary() {
		setSalary(this.salary * 1.02);
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
	public Date getStartingDate() {
		return startingDate;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Worker: " + this.name + " Starting Date: " + this.startingDate + " Salary: " + this.salary  + " Section: " + this.section;
	}
}
