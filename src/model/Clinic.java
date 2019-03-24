package model;

import java.util.ArrayList;

public class Clinic {

	//Static attributes
	public static final int MAX_ROOMS = 8;
	
	//Non-static attributes
	private String name;
	private ArrayList<Owner> owners;
	private Room[] rooms;
	
	//Constructor
	public Clinic(String n) {
		
		name = n;
		owners = new ArrayList<Owner>();
		rooms = new Room[MAX_ROOMS];
		
	}
	
	//Sets up the clinic
	public void setUp() {
		for(int i = 0; i < MAX_ROOMS; i++) {
			rooms[i] = new Room("Room " + (i+1), null, null, true);
		}
		
		for(int i = 0; i < MAX_ROOMS; i++) {
			System.out.println(rooms[i].getName());
		}
	}
	
	
	//adds an owner to the owners arraylist
	public void addOwner(String name, String id, String address, int phoneNumber) {
		owners.add(new Owner(name, id, address , phoneNumber));
	}
	
	//Adds a pet to the last owner on the arraylist of owners
	public void addPet(String name, String type, int age, double weight) {
		int index = owners.size() - 1;
		owners.get(index).addPet(name, type, age, weight);
	}
	
	//Getters
	public String getName() { return name; }
	public ArrayList<Owner> getOwners() { return owners; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setOwner(ArrayList<Owner> owns) { owners = owns; }
	
}
