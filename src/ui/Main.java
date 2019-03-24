package ui;
import model.Clinic;

public class Main {

	private Clinic johannios;

	//Main constructor 
	public Main() {
		johannios = new Clinic("Johannio's Veterinary Clinic");
	}
	
	//Invokes the clinic's set up method
	public void setUp() {
		johannios.setUp();
	}
	
	
	public static void main(String args[]) {
		
		Main m = new Main();
		m.setUp();
		m.run();
	}
	
	//handles input and output. quits when running = false
	public void run() {
		
		boolean running = true;
		
		while(running) {
			
			System.out.println(johannios.getName());
			running = false;
		}
		

	}
}
