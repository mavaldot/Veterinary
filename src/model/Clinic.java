package model;

public class Clinic {

	private String name;
	private Owner p;
	
	public Clinic() {
		
		p = new Owner();
		
	}
	
	public String getName() { return name; }
	
	public void setName(String nam) { name = nam; }
	
}
