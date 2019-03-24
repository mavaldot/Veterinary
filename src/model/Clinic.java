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
	private ArrayList<History> histories;
	
	//Constructor
	public Clinic(String n) {
		
		name = n;
		owners = new ArrayList<Owner>();
		rooms = new Room[MAX_ROOMS];
		revenue = 0;
		histories = new ArrayList<History>();
		
	}
	
	//Sets up the clinic
	public void setUp() {
		for(int i = 0; i < MAX_ROOMS; i++) {
			rooms[i] = new Room("Room " + (i+1), null, null, true);
		}
	}
	
	//Adds the medication to the record
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
	
	//Shows the records of all hospitalized animals
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
	
	//Finds the phone number given the owner's name
	public int findPhoneNumberWithOwnerName(String ownerName) {
		int phoneNumber = 0;
		for (Owner o : owners) {
			if(o.getName().equals(ownerName)) {
				phoneNumber = o.getPhoneNumber();
				break;
			}
		}
		
		return phoneNumber;
	}
	
	//Find the phone number given the pet's name
	public int findPhoneNumberWithPetName(String petName) {
		int phoneNumber = 0;
		for(Owner o : owners) {
			
			for(Pet p : o.getPets()) {
				if(p.getName().equals(petName)) {
					phoneNumber = o.getPhoneNumber();
					break;
				}
			}
		}
		
		return phoneNumber;
	}
	
	//Checks to see if the pet is currently hospitalized
	public boolean isHospitalized(String petName) {
		boolean hospitalized = false;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet().getName().equals(petName)) {
				hospitalized = true;
				break;
			}
		}
		
		return hospitalized;
	}
	
	//Calculates the cost of hospitalization of a particular pet
	public double calculateHospitalizationCost(String petName, int day, int month, int year) {
		double cost = 0;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet() != null) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					cost += rooms[i].calculateCost(day, month, year);
				}
			}
		}
		
		return cost;
		
	}
	
	//Release a pet. Returns true if a pet is released successfully
	public boolean releasePet(String petName, int day, int month, int year) {
		boolean success = false;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet() != null) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					rooms[i].getRecord().setState(Record.CLOSED);
					boolean foundPet = false;
					for(History h : histories) {
						if(h.getPetName().equals(petName)) {
							
							h.getRecords().add(rooms[i].getRecord());
							foundPet = true;
						}
					} if (!foundPet) {
						histories.add(new History(petName));
						histories.get(histories.size()-1).addRecord(rooms[i].getRecord());
					}
					
					revenue += calculateHospitalizationCost(petName, day, month, year);
					rooms[i].releasePet();
					
					success = true;
				}
			}
		}
		
		return success;
	}
	
	//Checks how many rooms a pet occupies
	public int howManyRooms(String petName) {
		int roomsNum = 0;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet() != null) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) 
					roomsNum++;
			}
		}
		return roomsNum;
	}
	
	//Checks the record history of a pet
	public String displayHistory(String petName) {
		
		String msg = "";
		boolean found = false;
		
		for(History h : histories) {
			if(h.getPetName().equals(petName)) {
				found = true;
				for(Record r : h.getRecords()) {
					msg += r.fullReport();
				}
			}
		}
		if(!found) {
			msg = petName + " does not have a record history in this clinic.";
		}
		
		return msg;
		
	}
	
	//Getters
	public String getName() { return name; }
	public double getRevenue() { return revenue; }
	public ArrayList<Owner> getOwners() { return owners; }
	public ArrayList<History> getHistories() { return histories; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setRevenue(double rev) { revenue = rev; }
	public void setOwner(ArrayList<Owner> owns) { owners = owns; }
	public void setHistories(ArrayList<History> hs) { histories = hs; }	
}
