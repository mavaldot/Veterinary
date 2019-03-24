package model;

public class Clinic {

	//Attributes
	private String name;
	private Owner p;
	
	//Constructor
	public Clinic(String n) {
		
		name = n;
		
	}
	
	public void setUp() {
		
	}
	
	//Getters
	public String getName() { return name; }
	
	//Setters
	public void setName(String nam) { name = nam; }
	
}
