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
	public Record(int st, Pet pt, Owner own, Date doe, String symp, String d, ArrayList<Medication> md) {
		state = st;
		pet = pt;
		owner = own;
		dateOfEntry = doe;
		symptoms = symp;
		diagnosis = d;
		medications = md;
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
	
