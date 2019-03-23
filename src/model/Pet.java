package model;

public class Pet {
	
	public static final String GATO = "gato";
	public static final String PERRO = "perro";
	public static final String AVE = "ave";
	public static final String OTRO = "otro";
	
	private String name;
	private String type;
	private int age;
	private double weight;
	
	public String getName() { return name; }
	public String getType() { return type; }
	public int getAge() { return age; }
	public double getWeight() { return weight; }
	
	public void setName(String name) { this.name = name; }
	public void setType(String type) { this.type = OTRO; }
	public void setAge(int age) { this.age = age; }
	public void setWeight(double weight) { this.weight = weight; }
	
}
