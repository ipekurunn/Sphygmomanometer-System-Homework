package main;
import java.util.ArrayList;
import java.util.Scanner;


public class Sphygmomanometer {
	
	private static ArrayList <PatientBloodPressure> patientList = new ArrayList<>();
	static String name;
	static int age;
	static int systolic;
	static int diastolic;
	static int pulse;
	
	public Sphygmomanometer(String name, int age, int systolic, int diastolic, int pulse) {
		this.name = name;
		this.age = age;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse= pulse;
	}
	
	public Sphygmomanometer() {
		
	}
	
	public static PatientBloodPressure getPatient(String name, int age, int systolic, int diastolic, int pulse) {
		PatientBloodPressure patient = new PatientBloodPressure();
		String patientName = patient.getName();
		patient.setName(name);
		patient.setAge(age);
		patient.setSystolic(systolic);
		patient.setDiastolic(diastolic);
		return patient;
	}
	
	public String checkBloodPressure() {
		if (systolic < 120 && diastolic < 80) {
			return "Normal";
		}
		else if (systolic > 119 && systolic <130 && diastolic < 80) {
			return "Elevated";
		}
		else if (systolic > 129 && systolic < 140 && diastolic > 79 && diastolic < 90) {
			return "Stage 1 High Blood Pressure";
		}
		else if (systolic > 139 && diastolic < 89)
		{
			return "Stage 2 High Blood Pressure";
		}
		else {
			return "Blood pressure measurement out of range!";
		}
	}
	
	public static void addPatient() {
		Scanner scanner;
		while (true)
		{
			scanner = new Scanner(System.in);
			System.out.println("Please enter patient name: ");
			if (scanner.hasNext("[A-Za-z]*")) {
				name = scanner.nextLine();
				break;
			}
			else {
				System.out.println("Invalid Input!");
			}
		}
		
		while (true)
		{
			scanner = new Scanner(System.in);
			System.out.println("Please enter patient age: ");
			if (scanner.hasNextInt()) {
				age = scanner.nextInt();
				if (age > 0 && age < 100) {
					break;
				}
				else {
					System.out.println("Invalid Input!");
				}
			}
			else {
				System.out.println("Invalid Input!");
			}
		}
		
		while (true)
		{
			scanner = new Scanner(System.in);
			System.out.println("Please enter patient systolic value: ");
			if (scanner.hasNextInt()) {
				systolic = scanner.nextInt();
				break;
			}
			else {
				System.out.println("Invalid Input!");
			}
		}
		
		while (true) {
			scanner = new Scanner(System.in);
			System.out.println("Please enter patient diastolic value: ");
			if (scanner. hasNextInt()) {
				diastolic = scanner.nextInt();
				break;
			}
			else {
				System.out.println("Invalid Input!");
			}
		}
		
		while (true) {
			scanner = new Scanner(System.in);
			System.out.println("Please enter patient pulse value: ");
			if (scanner.hasNextInt()) {
				pulse = scanner.nextInt();
				break;
			}
			else {
				System.out.println("Invalid Input!");
			}
		}
		
		PatientBloodPressure patient = new PatientBloodPressure(name, age, systolic, diastolic, pulse);
		patientList.add(patient);
		System.out.println("Patient added successfully!");
	}
	
	public static void deletePatient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter patient name you want to delete: ");
		String name = scanner.nextLine();
		boolean isDeleted = false;
		for (PatientBloodPressure patient : patientList) {
			if (patient.getName().equals(name)) {
				patientList.remove(patient);
				isDeleted = true;
				break;
			}
		}
		
		if (isDeleted) {
			System.out.println("Patient deleted successfully!");
		}
		else {
			System.out.println("Patient not found!");
		}
	}
	
	public static void calculate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the patient name to calculate averages: ");
		String name = scanner.nextLine();
		
		int count = 0;
		int totalSystolic = 0;
		int totalDiastolic = 0;
		int totalPulse = 0;
		
		for (PatientBloodPressure patient : patientList) {
			if(patient.getName().equals(name))
			{
				totalSystolic += patient.getSystolic();
				totalDiastolic += patient.getDiastolic();
				totalPulse += patient.getPulse();
				count++;
			}
			else {
				System.out.println("Patient not found!");
			}
		}
		
		if (count == 0) {
			System.out.println("Patient not found!");
		}
		else {
			double averageSystolic = ((double) totalSystolic) / count;
			double averageDiastolic = ((double) totalDiastolic) / count;
			double averagePulse = ((double) totalPulse) / count;
			System.out.println("Average value of Systolic: " + averageSystolic);
			System.out.println("Average value of Diastolic: " + averageDiastolic);
			System.out.println("Average value of Pulse: " + averagePulse);
		}
	}
	
	public static void displayMinMax()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the patient name to see maximum and minimum values: ");
		String name = scanner.nextLine();
		
		int minSystolic = Integer.MAX_VALUE;
		int maxSystolic = Integer.MIN_VALUE;
		int minDiastolic = Integer.MAX_VALUE;
		int maxDiastolic = Integer.MIN_VALUE;
		int minPulse = Integer.MAX_VALUE;
		int maxPulse = Integer.MIN_VALUE;
		boolean isFound = false;
		
		for (PatientBloodPressure patient :patientList) {
			if (patient.getName().equals(name)) {
				int systolic = patient.getSystolic();
				if (systolic < minSystolic) {
					minSystolic = systolic;
				}
				if (systolic > maxSystolic) {
					maxSystolic = systolic;
				}
				
				int diastolic = patient.getDiastolic();
				if (diastolic < minDiastolic) {
					minDiastolic = diastolic;
				}
				if (diastolic > maxDiastolic) {
					maxDiastolic = diastolic;
				}
				
				int pulse = patient.getPulse();
				if (pulse < minPulse) {
					minPulse = pulse;
				}
				if (pulse > maxPulse) {
					maxPulse = pulse;
				}
			}
		}
		
		System.out.println("Systolic: \n\tMax Value: " + maxSystolic + "\n\tMin Value: " + minSystolic);
		System.out.println("Diastolic: \n\tMax Value: " + maxDiastolic + "\n\tMin Value: " + minDiastolic);
		System.out.println("Pulse: \n\tMax Value: " + maxPulse + "\n\tMin Value: " + minPulse);
	}
	
	public static void patientCategory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the patient name to see patient category: ");
		String name = scanner.nextLine();
		
		for (PatientBloodPressure patient : patientList) {
			if (patient.getName().equals(name)) {
				int systolic = patient.getSystolic();
				int diastolic = patient.getDiastolic();
				int age = patient.getAge();
				
				if(systolic < 120 && diastolic < 80) {
					System.out.println("Patient Category: \n\tNormal.");
				}
				else if (systolic > 119 && systolic <130 && diastolic < 80) {
					System.out.println("Patient Category: \n\tElevated.");
				}
				else if (systolic > 129 && systolic < 140 && diastolic > 79 && diastolic < 90 && age > 70) {
					System.out.println("Patient Category: \n\tStage 1 High Blood Pressure! \n\tUrgent! Please call 112.");
				}
				else if (systolic > 139 && diastolic > 89 && age > 70) {
					System.out.println("Patient Category: \n\tStage 2 High Blood Pressure! \n\tUrgent! Please call 112.");
				}
				else {
					System.out.println("Blood pressure measurement out of range!");
				}
			}
		}
	}
}
