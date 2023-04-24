package main;
import java.util.Scanner;
import java.util.ArrayList;

public class SphygmomanometerApp 
{
	private static ArrayList<PatientBloodPressure> patientList = new ArrayList<>();
	private static Scanner scanner;
	private static Sphygmomanometer sphygmomanometer = new Sphygmomanometer();
	
	public static void main(String[] arg) {
		int choice;
		
		do {
			System.out.println("******************************");
			System.out.println("Menu:");
			System.out.println("1- Insert a patient record");
			System.out.println("2- Delete a patient record");
			System.out.println("3- Calculate average values");
			System.out.println("4- Display Min/Max values");
			System.out.println("5- Category of the patient");
			System.out.println("0- Exit");
			System.out.println("Enter a number from the menu: ");
			
			scanner = new Scanner(System.in);
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if (choice >= 0 && choice <= 5) {
					switch (choice) 
					{
						case 0:
							System.out.println("Exiting...");
							System.out.println("Goodbye!");
							System.exit(0);
						case 1:
							sphygmomanometer.addPatient();
							break;
						case 2:
							sphygmomanometer.deletePatient();
							break;
						case 3:
							sphygmomanometer.calculate();
							break;
						case 4:
							sphygmomanometer.displayMinMax();
							break;
						case 5:
							sphygmomanometer.patientCategory();
							break;
					}
					System.out.println("----------------------------------");
					
				}
				
				else {
					System.out.println("\\nPlease enter a valid value!");
					System.out.println("");
				}
			}
			
			else {
				System.out.println("\\nPlease enter a valid value!");
				System.out.println("");
			}
		}
		
		while (true);
	}
}
