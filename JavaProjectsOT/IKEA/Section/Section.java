package IKEA.Section;

import java.util.ArrayList;

import IKEA.Worker.Worker;

public class Section {
	private double area;
	private ArrayList<Worker> workers;
	private String name;
	public Section(double area, ArrayList<Worker> workers, String name) {
		this.area = area;
		this.workers = workers;
		this.name = name;
	}
	public Section(double area, String name) {
		this.area = area;
		this.workers = new ArrayList<Worker>();
		this.name = name;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public ArrayList<Worker> getWorkers() {
		return workers;
	}
	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
