package model;

public class Medication {

	private String name;
	private double dose;
	private double costPerDose;
	private double frequency;
	
	public Medication(String n, double d, double cpd, double f) {
		name = n;
		dose = d;
		costPerDose = cpd;
		frequency = f;
	}
	
	
}
