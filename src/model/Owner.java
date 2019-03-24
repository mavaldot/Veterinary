package model;

import java.util.ArrayList;

public class Owner {

	//Attributes
	private String name;
	private String id;
	private String address;
	private int phoneNumber;
	
	private ArrayList<Pet> pets;
	
	//Constructor
	public Owner(String n, String theid, String addr, int pn) {
		name = n;
		id = theid;
		address = addr;
		phoneNumber = pn;
		pets = new ArrayList<Pet>();
	}
	
	//
	public void addPet(String name, String type, int age, double weight) {
		pets.add(new Pet(name, type, age, weight));
	}
	
	//Getters
	public String getName() { return name; }
	public String getId() { return id; }
	public String getAddress() { return address; }
	public int phoneNumber() { return phoneNumber; }
	public ArrayList<Pet> getPets() { return pets; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setId(String theid) { id = theid; }
	public void setAddress(String a) { address = a; }
	public void setPhoneNumber(int pn) { phoneNumber = pn; }
	public void setPets(ArrayList<Pet> pts) { pets = pts; }
	
}
