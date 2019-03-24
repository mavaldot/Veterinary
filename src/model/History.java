package model;

import java.util.ArrayList;

public class History {

	//Attributes
	private String petName;
	private ArrayList<Record> records;
	
	//Constructor
	public History(String name) {
		petName = name;
		records = new ArrayList<Record>();
	}
	
	public void addRecord(Record record) {
		records.add(record);
	}
	
	//Getters
	public String getPetName() { return petName; }
	public ArrayList<Record> getRecords() { return records; }
	
	//Setters
	public void setPetName(String name) { petName = name; }
	public void setRecords(ArrayList<Record> rs) { records = rs; }
	
}
