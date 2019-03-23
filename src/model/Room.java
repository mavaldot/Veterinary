package model;

public class Room {

	private Pet currentPet;
	private Record record;
	private boolean available;
	
	public Room(Pet cpt, Record rc, boolean a) {
		currentPet = cpt;
		record = rc;
		available = a;
	}
	
	public Pet getCurrentPet() { return currentPet; }
	public Record getRecord() { return record; }
	public boolean getAvailable() { return available; }
	
	public void setCurrentPet(Pet cp) { currentPet = cp; }
	public void setRecord(Record r) { record = r; }
	public void setAvailable(boolean a) { available = a; }
	
}
