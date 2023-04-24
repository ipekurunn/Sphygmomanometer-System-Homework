package main;

public class PatientBloodPressure {
	
	private String name;
	private int age;
	private int systolic;
	private int diastolic;
	private int pulse;
	
	public PatientBloodPressure() {
		
	}
	
	public PatientBloodPressure(String name, int age, int systolic, int diastolic, int pulse) {
		this.name = name;
		this.age = age;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse= pulse;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSystolic() {
		return systolic;
	}
	
	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}
	
	public int getDiastolic() {
		return diastolic;
	}
	
	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}
	
	public int getPulse()
	{
		return pulse;
	}
	
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	
	public String toString() {
		return "Patient Name" + name + "\nAge: " + age + "\nSystolic: " + systolic + "\nDiastolic: " + diastolic + "\nPulse: " + pulse;
	}

}
