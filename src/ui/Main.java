package ui;

import java.util.Scanner;

import model.Clinic;
import model.Pet;

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
		boolean asking = false;
		Scanner s = new Scanner(System.in);
		
		while(running) {
			System.out.println("\nPlease pick an option:");
			System.out.println("1. Register a new human client and his/her pets");
			System.out.println("2. Hospitalize a pet");
			System.out.println("3. ");
			
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
				
				asking = true;
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
				
				boolean addingPets = true;
				
				while(addingPets) {
					
					System.out.println("Please enter the name of the pet");
					String petName = s.nextLine();
					
					int petTypeInt = 0;
					String petType = "";
					asking = true;
					while(asking) {
						System.out.println("Please choose the type of the pet");
						System.out.println("1. Cat");
						System.out.println("2. Dog");
						System.out.println("3. Bird");
						System.out.println("4. Other");
						String type = s.nextLine();
						try {
							petTypeInt = Integer.parseInt(type);
							switch(petTypeInt) {
							
							case 1:
								petType = Pet.CAT;
								asking = false;
								break;
								
							case 2:
								petType = Pet.DOG;
								asking = false;
								break;
								
							case 3:
								petType = Pet.BIRD;
								asking = false;
								break;
								
							case 4:
								petType = Pet.OTHER;
								asking = false;
								break;
								
							default:
								System.out.println("ERROR. Please enter a valid number");
								break;
							}
						} catch (NumberFormatException e) {
							System.out.println("ERROR. Please enter a valid number");
						}

					}
					
			
					
					int petAgeNum = 0;
					asking = true;
					while(asking) {
						System.out.println("Please enter the age of the pet");
						String petAge = s.nextLine();
						try {
							petAgeNum = Integer.parseInt(petAge);
							asking = false;
						} catch (NumberFormatException e) {
							System.out.println("ERROR. Please enter a valid age");
						}

					}

					double petWeightDouble = 0;
					asking = true;
					while(asking) {
						System.out.println("Please enter the weight of the pet");
						String petWeight = s.nextLine();
						try {
							petWeightDouble = Double.parseDouble(petWeight);
							asking = false;
						} catch (NumberFormatException e) {
							System.out.println("ERROR. Please enter a valid weight.");
						}
					}
					
					johannios.addPet(petName, petType, petAgeNum, petWeightDouble);
					
					asking = true;
					while(asking) {
						System.out.println("Does this client have another pet?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						String ans = s.nextLine();
						int ansNum = 0;
						try {
							ansNum = Integer.parseInt(ans);
							
							switch(ansNum) {
							
							case 1:
								asking = false;
								System.out.println(" ");
								break;
								
							case 2:
								asking = false;
								addingPets = false;
								break;
								
							default:
								System.out.println("ERROR. PLEASE ENTER A VALID CHOICE");
								break;
							
							}
						} catch (NumberFormatException e) {
							System.out.println("ERROR. PLEASE ENTER A VALID CHOICE");
						}
						

					}
				}

				System.out.println("The client and his/her pets were added successfully.");
				
				break;
				
			case 2:
				
				
				break;
				
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
