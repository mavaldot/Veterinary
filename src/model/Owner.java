package model;

import java.util.ArrayList;

public class Owner {

	//Attributes
	private String name;
	private int id;
	private String address;
	private int phoneNumber;
	
	private ArrayList<Pet> pet;
	
	//
	public Owner() {
		
	}
	
	//Getters
	public String getName() { return name; }
	public int getId() { return id; }
	public String getAddress() { return address; }
	public int phoneNumber() { return phoneNumber; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setId(int theid) { id = theid; }
	public void setAddress(String a) { address = a; }
	public void setPhoneNumber(int pn) { phoneNumber = pn; }
	
}
