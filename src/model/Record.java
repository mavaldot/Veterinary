package model;

import java.util.ArrayList;

public class Record {

	//Static attributes
	public static final int CLOSED = 0;
	public static final int OPEN = 1;
	
	//Non-static attributes
	private int state;
	private Pet pet;
	private Owner owner;
	private Date dateOfEntry;
	private String symptoms;
	private String diagnosis;
	private ArrayList<Medication> medications;
	
	//Constructor
	public Record(int st, Pet pt, Owner own, Date doe, String symp, String d) {
		state = st;
		pet = pt;
		owner = own;
		dateOfEntry = doe;
		symptoms = symp;
		diagnosis = d;
		medications = new ArrayList<Medication>();
	}
	
	public String fullReport() {
		String msg = "";
		msg += "\nState: ";
		if(state == CLOSED) {
			msg += "CLOSED\n";
		} else if(state == OPEN) {
			msg += "OPEN\n";
		}
		msg += "\nPet info: \n";
		msg += pet.fullReport();
		msg += "Date of entry: " + dateOfEntry.reportDate();
		msg += "\nOwner info: \n";
		msg += owner.fullReport();
		msg += "\nSymptoms: " + symptoms + "\n";
		msg += "Diagnosis: " + diagnosis + "\n";
		if(medications != null) {
			msg += "\nMedications info: \n";
			for(Medication m : medications) {
				m.fullReport();
			}
		} else {
			msg += "\nMedications: None\n";
		}
		
		return msg;
		
	}
	
	//Getters
	public int getState() { return state; }
	public Pet getPet() { return pet; }
	public Owner getOwner() { return owner; }
	public Date getDateOfEntry() { return dateOfEntry; }
	public String getSymptoms() { return symptoms; }
	public String getDiagnostic() { return diagnosis; }
	public ArrayList<Medication> getMedications() { return medications; }
	
	//Setters
	public void setState(int st) { state = st; }
	public void setPet (Pet pt) { pet = pt; }
	public void setOwner(Owner ownr) { owner = ownr; }
	public void setDateOfEntry(Date dt) { dateOfEntry = dt; }
	public void setSymptoms(String symp) { symptoms = symp; }
	public void setDiagnosis(String diag) { diagnosis = diag; }
	public void setMedications(ArrayList<Medication> md) { medications = md; }
	
}
	
