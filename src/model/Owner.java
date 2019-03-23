package model;

import java.util.ArrayList;

public class Owner {

	private String name;
	private int id;
	private String address;
	private int phoneNumber;
	
	private ArrayList<Pet> pet;
	
	public Owner() {
		
		pet = new ArrayList<Pet>();
		System.out.println(Pet.GATO);
		
	}
	
}
