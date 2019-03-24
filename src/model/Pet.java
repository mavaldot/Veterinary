package model;

public class Pet {
	
	//Static attributes
	public static final String GATO = "gato";
	public static final String PERRO = "perro";
	public static final String AVE = "ave";
	public static final String OTRO = "otro";
	
	//Non-static attributes
	private String name;
	private String type;
	private int age;
	private double weight;
	
	public Pet(String n, String t, int a, double w) {
		name = n;
		type = t;
		age = a;
		weight = w;
	}
	
	//Getters
	public String getName() { return name; }
	public String getType() { return type; }
	public int getAge() { return age; }
	public double getWeight() { return weight; }
	
	//Setters
	public void setName(String name) { this.name = name; }
	public void setType(String type) { this.type = OTRO; }
	public void setAge(int age) { this.age = age; }
	public void setWeight(double weight) { this.weight = weight; }
	
}
