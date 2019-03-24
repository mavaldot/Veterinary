package model;

public class Date {

	//Attributes
	private int day;
	private int month;
	private int year;
	
	//Constructors
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	//Getters
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
	//Setters
	public void setDay(int d) { day = d; }
	public void setMonth(int m) { month = m; }
	public void setYear(int y) { year = y; }
}
