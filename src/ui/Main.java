package ui;

import java.text.ParseException;
import java.util.Scanner;

import model.Clinic;

public class Main {

	private Clinic johannios;

	//Main constructor 
	public Main() {
		johannios = new Clinic("Johannio's Veterinary Clinic");
	}
	
	public static void main(String args[]) {
		
		Main m = new Main();
		m.setUp();
		m.run();
	}
	
	public void setUp() {
		johannios.setUp();
	}
	
	//handles input and output. quits when running = false
	public void run() {
		
		System.out.println("Welcome to " + johannios.getName() + "!");
		
		boolean running = true;
		Scanner s = new Scanner(System.in);
		
		while(running) {
			System.out.println("\nPlease pick an option:");
			System.out.println("1. Register a new human client and his/her pets");
			
			String choice = s.nextLine();
			int choiceNum = 0;
			
			try {
				choiceNum = Integer.parseInt(choice);
			} catch(NumberFormatException e) {
				System.out.println("ERROR. Please enter a NUMBER.");
			}

			
			switch(choiceNum) {
			
			case 1:
				System.out.println("Please enter the name of the client");
				String name = s.nextLine();
				
				System.out.println("Please enter the ID of the client");
				String id = s.nextLine();
				
				System.out.println("Please enter the address of the client");
				String address = s.nextLine();
				
				boolean asking = true;
				int phoneNumber = 0;
				while(asking) {
					
					System.out.println("Please enter the phone number of the client");
					String phone = s.nextLine();

					try {
						phoneNumber = Integer.parseInt(phone);
						asking = false;
					} catch (NumberFormatException e) {
						System.out.println("Please enter a valid phone number");
					}
					
				}
				
				johannios.addOwner(name, id, address, phoneNumber);
				
				System.out.println("Please enter the name of the pet");
				String petName = s.nextLine();
				System.out.println("Please enter the type of the pet");
				String petType = s.nextLine();
				System.out.println("Please enter the age of the pet");
				String petAge = s.nextLine();
				int petAgeNum = Integer.parseInt(petAge);
				
				System.out.println("Please enter the weight of the pet");
				String petWeight = s.nextLine();
				double petWeightDouble = Double.parseDouble(petWeight);
				
				johannios.addPet(petName, petType, petAgeNum, petWeightDouble);
				
				break;
				
			case 2:
				
				
				
			case 10:
				running = false;
				System.out.println("Goodbye");
				break;
				
			default:
				
				System.out.println("PLEASE ENTER A VALID CHOICE.");
			
			}
			
		}
		

	}
}
