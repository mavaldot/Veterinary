package model;

import java.util.ArrayList;

public class Record {

	public static final int CLOSED = 0;
	public static final int OPEN = 1;
	
	private int state;
	private Pet pet;
	private Owner owner;
	private Date dateOfEntry;
	private String symptoms;
	private String possibleDiagnostic;
	private ArrayList<Medication> medications;
	
	public Record(int st, Pet pt, Owner own, Date doe, String symp, String pd, ArrayList<Medication> md) {
		state = st;
		pet = pt;
		owner = own;
		dateOfEntry = doe;
		symptoms = symp;
		possibleDiagnostic = pd;
		medications = md;
	}
	
	
}
