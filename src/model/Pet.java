package model;

public class Pet {
	
	//Static attributes
	public static final String CAT = "cat";
	public static final String DOG = "dog";
	public static final String BIRD = "bird";
	public static final String OTHER = "other";
	
	//Non-static attributes
	private String name;
	private String type;
	private int age;
	private double weight;
	
	//Constructor
	public Pet(String n, String t, int a, double w) {
		name = n;
		type = t;
		age = a;
		weight = w;
	}
	
	public String fullReport() {
		String report = "";
		report += "Name: " + name + "\n";
		report += "Type: " + type + "\n";
		report += "Age: " + age + "\n";
		report += "Weight: " + weight + "\n";
		
		return report;
	}
	
	//Getters
	public String getName() { return name; }
	public String getType() { return type; }
	public int getAge() { return age; }
	public double getWeight() { return weight; }
	
	//Setters
	public void setName(String name) { this.name = name; }
	public void setType(String type) { this.type = type; }
	public void setAge(int age) { this.age = age; }
	public void setWeight(double weight) { this.weight = weight; }
	
}
