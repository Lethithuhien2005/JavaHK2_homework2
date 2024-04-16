package Exercise_IOStream;

import java.util.Scanner;

public class HR {
	private String name;
	private int day;
	private int month;
	private int year;
	private double coeffSalary;

	public HR(String name, int day, int month, int year, double coeffSalary) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.coeffSalary = coeffSalary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getCoeffSalary() {
		return coeffSalary;
	}
	public void setCoeffSalary(double coeffSalary) {
		this.coeffSalary = coeffSalary;
	}
}
