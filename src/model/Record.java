package model;

import java.util.ArrayList;

public class Record {

	//Static attributes
	public static final int CLOSED = 0;
	public static final int OPEN = 1;
	
	//Non-static attributes
	private int state;
	private Pet pet;
	private Owner owner;
	private Date dateOfEntry;
	private String symptoms;
	private String diagnosis;
	private ArrayList<Medication> medications;
	
	//Constructor
	public Record(int st, Pet pt, Owner own, Date doe, String symp, String d) {
		state = st;
		pet = pt;
		owner = own;
		dateOfEntry = doe;
		symptoms = symp;
		diagnosis = d;
		medications = new ArrayList<Medication>();
	}
	
	public String fullReport() {
		String msg = "";
		msg += "\nState: ";
		if(state == CLOSED) {
			msg += "CLOSED\n";
		} else if(state == OPEN) {
			msg += "OPEN\n";
		}
		msg += "\nPet info: \n";
		msg += pet.fullReport();
		msg += "Date of entry: " + dateOfEntry.reportDate();
		msg += "\nOwner info: \n";
		msg += owner.fullReport();
		msg += "\nSymptoms: " + symptoms + "\n";
		msg += "Diagnosis: " + diagnosis + "\n";
		if(medications != null) {
			msg += "\nMedications info: \n";
			for(Medication m : medications) {
				m.fullReport();
			}
		} else {
			msg += "\nMedications: None\n";
		}
		
		return msg;
		
	}
	
	//Getters
	public int getState() { return state; }
	public Pet getPet() { return pet; }
	public Owner getOwner() { return owner; }
	public Date getDateOfEntry() { return dateOfEntry; }
	public String getSymptoms() { return symptoms; }
	public String getDiagnostic() { return diagnosis; }
	public ArrayList<Medication> getMedications() { return medications; }
	
	//Setters
	public void setState(int st) { state = st; }
	public void setPet (Pet pt) { pet = pt; }
	public void setOwner(Owner ownr) { owner = ownr; }
	public void setDateOfEntry(Date dt) { dateOfEntry = dt; }
	public void setSymptoms(String symp) { symptoms = symp; }
	public void setDiagnosis(String diag) { diagnosis = diag; }
	public void setMedications(ArrayList<Medication> md) { medications = md; }

	//Calculates the cost of the hospitalization
	public double calculateCost(int day, int month, int year) {
		double cost = 0;

		int days = 0;
		int entryDay = dateOfEntry.getDay();
		int entryMonth = dateOfEntry.getMonth();
		int entryYear = dateOfEntry.getYear();
		
		while(entryYear < year) {
			if(entryMonth == 1) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 2) {
				while(entryDay <= 28) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 3) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 4) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 5) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 6) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 7) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 8) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 9) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 10) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 11) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 12) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth = 1;
				entryYear++;
			}
		}
		
		if(year == entryYear) {
			while(entryMonth < month) {
				if(entryMonth == 1) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 2) {
					while(entryDay <= 28) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 3) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 4) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 5) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 6) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 7) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 8) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 9) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 10) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 11) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				
			}
			if(entryMonth == month) {
				while(entryDay < day) {
					entryDay++;
					days++;
				}
			}
		}
		
		double weight = pet.getWeight();
		
		if(pet.getType().equals(Pet.CAT)) {
			
			if(weight >= 1 && weight <= 3) {
				cost = 10000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 12000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 15000 *  days;
			} else if(weight > 20) {
				cost = 20000 * days;
			} else {
				cost = 0;
			}
			
		} else if(pet.getType().equals(Pet.DOG)) {
			
			if(weight >= 1 && weight <= 3) {
				cost = 15000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 17000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 20000 *  days;
			} else if(weight > 20) {
				cost = 25000 * days;
			} else {
				cost = 0;
			}
			
		} else if(pet.getType().equals(Pet.BIRD)) {
			
			if(weight >= 1 && weight <= 3) {
				cost = 10000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 12000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 20000 *  days;
			} else if(weight > 20) {
				cost = 25000 * days;
			} else {
				cost = 0;
			}
			
		} else if(pet.getType().equals(Pet.OTHER)) {
		
			if(weight >= 1 && weight <= 3) {
				cost = 10000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 17000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 30000 *  days;
			} else if(weight > 20) {
				cost = 30000 * days;
			} else {
				cost = 0;
			}
		}
		
		for(Medication m : medications) {
			cost += days * m.getDose() * m.getCostPerDose() * m.getFrequency();
		}
		
		return cost;
	}
	
}
	
