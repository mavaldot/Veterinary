package model;

public class Room {

	//Attributes
	private String name;
	private Pet currentPet;
	private Record record;
	private boolean available;
	
	//Constructor
	public Room(String n, Pet cpt, Record rc, boolean a) {
		name = n;
		currentPet = cpt;
		record = rc;
		available = a;
	}
	
	public void fillRoom(Pet cpt, Owner own, int day, int month, int year, String symptoms, String diagnosis) {
		currentPet = cpt;
		record = new Record(Record.OPEN, cpt, own, new Date(day, month, year), symptoms, diagnosis);
		available = false;
	}
	
	
	
	//Getters
	public String getName() { return name; }
	public Pet getCurrentPet() { return currentPet; }
	public Record getRecord() { return record; }
	public boolean getAvailable() { return available; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setCurrentPet(Pet cp) { currentPet = cp; }
	public void setRecord(Record r) { record = r; }
	public void setAvailable(boolean a) { available = a; }
	
}
