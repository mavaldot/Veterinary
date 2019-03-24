package model;

import java.util.ArrayList;

public class Clinic {

	//Static attributes
	public static final int MAX_ROOMS = 8;
	
	//Non-static attributes
	private String name;
	private ArrayList<Owner> owners;
	private Room[] rooms;
	private double revenue;
	
	//Constructor
	public Clinic(String n) {
		
		name = n;
		owners = new ArrayList<Owner>();
		rooms = new Room[MAX_ROOMS];
		revenue = 0;
		
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
	
	public boolean addMedication(String petName, String medName, double dose, double costPerDose, double frequency) {
		boolean success = false;
		for(int i = 0; i < MAX_ROOMS; i++) {
			
			if(!rooms[i].getAvailable()) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					rooms[i].getRecord().getMedications().add(new Medication(medName, dose, costPerDose, frequency));
					success = true;
				}
			}
		}
		
		return success;
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
	
	//HOSPITALIZES A PET IN A ROOM. IT IS AN INT BECAUSE THE MESSAGE I WILL SHOW IN THE MAIN CLASS DEPENDS ON THE INT THE FUNCTION RETURNS
	public int hospitalizePet(String ownerName, String petName, int day, int month, int year, String symptoms, String diagnosis) {
		int status = 0;
		Owner owner = null;
		Pet pet = null;
		for(Owner o : owners) {
			if(o.getName().equals(ownerName)) {
				for(Pet p : o.getPets()) {
					if(p.getName().equals(petName)) {
						owner = o;
						pet = p;
					}
				}
			}
		}
		
		if(pet == null) {
			status = 1;
		} else {
			boolean success = false;
			for(int i = 0; i < MAX_ROOMS && !success; i++) {
				if(rooms[i].getAvailable()) {
					rooms[i].fillRoom(pet, owner, day, month, year, symptoms, diagnosis);
					status = 2;
					success = true;
				}
			}
			
		}
		
		return status;
	}
	
	public String showHospitalizedAnimalRecords() {
		String msg = "";
		for(int i = 0; i < MAX_ROOMS; i++) {
				msg += "\n" + rooms[i].getName() + ": \n";
				if(rooms[i].getRecord() != null) {
					msg += rooms[i].getRecord().fullReport();
				} else {
					msg += "EMPTY\n";
				}

			}
		
		return msg;
	}
	
	//Getters
	public String getName() { return name; }
	public double getRevenue() { return revenue; }
	public ArrayList<Owner> getOwners() { return owners; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setRevenue(double rev) { revenue = rev; }
	public void setOwner(ArrayList<Owner> owns) { owners = owns; }
	
}
