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
			System.out.println("3. Display the records of all the currently hospitalized animals");
			System.out.println("4. Obtain the phone number of a pet's owner");
			
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
				
				System.out.println("Please enter the name of the pet you want to hospitalize");
				String petName = s.nextLine();
				
				//I ASK FOR THE NAME OF THE OWNER BECAUSE TWO DIFFERENT PETS CAN HAVE THE SAME NAME
				System.out.println("Please enter the name of the owner of this pet");
				String ownerName = s.nextLine();
				
				int day = 0;
				asking = true;
				while(asking) {
					System.out.println("Please enter the current day of the month");
					String dayStr = s.nextLine();
					try {
						day = Integer.parseInt(dayStr);
						asking = false;
					} catch (NumberFormatException e) {
						System.out.println("ERROR. Please enter a number.");
					}

				}
				
				int month = 0;
				asking = true;
				while(asking) {
					System.out.println("Please enter the current month");
					String monthStr = s.nextLine();
					try {
						month = Integer.parseInt(monthStr);
						asking = false;
					} catch (NumberFormatException e) {
						System.out.println("ERROR. Please enter a number.");
					}

				}
				
				int year = 0;
				asking = true;
				while(asking) {
					System.out.println("Please enter the current year");
					String yearStr = s.nextLine();
					try {
						year = Integer.parseInt(yearStr);
						asking = false;
					} catch (NumberFormatException e) {
						System.out.println("ERROR. Please enter a number.");
					}

				}
				
				System.out.println("Please enter the symptoms");
				String symptoms = s.nextLine();
				
				System.out.println("Please enter the possible diagnosis");
				String diagnosis = s.nextLine();
				
				//IT IS AN INT BECAUSE THE MESSAGE I WILL SHOW DEPENDS ON THE INT THE FUNCTION RETURNS
				int hospitalizeStatus = johannios.hospitalizePet(ownerName, petName, day, month, year, symptoms, diagnosis);
				
				switch(hospitalizeStatus) {
				
				case 0:
					System.out.println("ERROR. There is no room available");
					break;
				case 1:
					System.out.println("ERROR. Could not find the pet.");
					break;
				case 2:

					System.out.println("The pet was hospitalized successfully");
					System.out.println("Was this pet prescribed any medication?");
					int medChoiceNum = 0;
					boolean askingMedication = true;
					while(askingMedication) {
						
						System.out.println("1. Yes");
						System.out.println("2. No");
						
						String medChoice = s.nextLine();
						try {
							medChoiceNum = Integer.parseInt(medChoice);
							switch(medChoiceNum) {
							
							case 1:
								System.out.println("Please enter the name of the medication");
								String medName = s.nextLine();
								
								double doseDouble = 0;
								asking = true;
								while(asking) {
									System.out.println("Please enter the dose of the medication");
									String dose = s.nextLine();
									try {
										doseDouble = Double.parseDouble(dose);
										asking = false;
									} catch (NumberFormatException e) {
										System.out.println("ERROR. Please enter a valid dose.");
									}
								}
								
								double costPerDoseDouble = 0;
								asking = true;
								while(asking) {
									System.out.println("Please enter the cost per dose of the medication");
									String costPerDose = s.nextLine();
									try {
										costPerDoseDouble = Double.parseDouble(costPerDose);
										asking = false;
									} catch (NumberFormatException e) {
										System.out.println("ERROR. Please enter a valid cost per dose.");
									}
								}
								
								double frequencyDouble = 0;
								asking = true;
								while(asking) {
									System.out.println("Please enter the frequency (per day) of the medication");
									String frequency = s.nextLine();
									try {
										frequencyDouble = Double.parseDouble(frequency);
										asking = false;
									} catch (NumberFormatException e) {
										System.out.println("ERROR. Please enter a valid frequency.");
									}
								}
								
								if(johannios.addMedication(petName, medName, doseDouble, costPerDoseDouble, frequencyDouble))
									System.out.println("The medication was added successfully");
								else
									System.out.println("ERROR. Could not add the medication");
								
								
								System.out.println("Was this pet prescribed any other medication?");
								break;
							case 2:
								askingMedication = false;
								break;
							default:
								System.out.println("ERROR. Please enter a valid number");
								break;
							}
						} catch (NumberFormatException e) {
							System.out.println("ERROR. Please enter a number.");
						}

					}
					
					
					
					break;
				default:
					System.out.println("ERROR");
					break;
				
				}
				
				break;
				
			case 3:
				
				String msg = johannios.showHospitalizedAnimalRecords();
				
				System.out.println(msg);
				break;
				
			case 4:
				
				int nameChoiceNum = 0;
				asking = true;
				while(asking) {
					try {
						
						System.out.println("Do you know the owner's name or the pet's name?");
						System.out.println("1. Owner's name");
						System.out.println("2. Pet's name");
						String nameChoice = s.nextLine();
						nameChoiceNum = Integer.parseInt(nameChoice);
						switch(nameChoiceNum) {
						case 1:
							System.out.println("Please enter the name of the owner");
							String findOwnerName = s.nextLine();
							
							asking = false;
							break;
						case 2:
							System.out.println("Please enter the name of the pet");
							String findPetName = s.nextLine();
							
							asking = false;
							break;
						default:
							System.out.println("ERROR. Please enter a valid number");
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("ERROR. Please enter a number.");
					}

				}
				
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
