/*
4. Hospital Management System:
Scenario: Create a hospital management system to handle various medical staff and patient records.

Requirements:

Encapsulation: Develop classes Patient and MedicalStaff with private fields for details such as patient ID, name, and medical conditions, and staff ID, name, and role. 
Provide public methods to access and update these fields.
Inheritance: Implement a base class Person with common attributes like name and age. Extend Person to create Patient and Doctor classes. Doctor should include 
attributes such as specialization, while Patient should include medical history.
Polymorphism: Create an interface Scheduleable with a method scheduleAppointment(Date date). Implement this interface in Doctor and Nurse classes to handle 
different scheduling procedures.
Abstraction: Define an abstract class HospitalDepartment with abstract methods addStaff(Staff staff) and removeStaff(Staff staff). Create concrete classes like 
EmergencyDepartment and GeneralWard that extend HospitalDepartment and provide specific implementations for staff management.
*/

class MedicalStaff{
	private int staffID;
	private String name,role;
	MedicalStaff(int staffID, String name,String role){
		this.staffID = staffID;
		this.name = name;
		this.role = role;
	}
	public int getStaffId(){
		return staffID;
	}
	public String getStaffName(){
		return name;
	}
	public String getStaffRole(){
		return  role;
	}
}
abstract class HospitalDepartment{
	public abstract void addStaff(MedicalStaff staff);
	public abstract void removeStaff(MedicalStaff staff);
}
class EmergencyDepartment extends HospitalDepartment{
	
	public void addStaff(MedicalStaff staff){
		System.out.println("Emergency Department Staff Added.................................");
		MedicalStaff staff1 = staff;
		System.out.println("Staff Id: "+staff.getStaffId());
		System.out.println("Staff name: "+staff.getStaffName());
		System.out.println("Staff Role: "+staff.getStaffRole());
	}
	public void removeStaff(MedicalStaff staff){
		MedicalStaff staff1 = null;
		System.out.println("Emergency Department  Staff Removed..........");
	}
}
class GeneralWard extends HospitalDepartment{
	
	public void addStaff(MedicalStaff staff){
		System.out.println("General Ward Staff Added.................................");
		MedicalStaff staff1 = staff;
		System.out.println("Staff Id: "+staff.getStaffId());
		System.out.println("Staff name: "+staff.getStaffName());
		System.out.println("Staff Role: "+staff.getStaffRole());
	}
	public void removeStaff(MedicalStaff staff){
		 staff = null;
		System.out.println("General Ward Staff Removed..........");
	}
}
class Person{
	String name;
	int age;
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}
interface Scheduleable{
	public void scheduleAppointment(String date);
}
class Nurse extends Person implements Scheduleable{
	int staffId;
	Nurse(String name, int age, int staffId){
		this.name = name;
		this.age = age;
		this.staffId = staffId;
	}
	public void scheduleAppointment(String date){
		System.out.println("Appointment Date: "+date);
	}
}
class Doctor extends Person implements Scheduleable{
	String specialization;
	Doctor(String name, int age, String specialization){
		this.name = name;
		this.age = age;
		this.specialization = specialization;
	}
	public String getSpecialization(){
		return specialization;
	}
	public void scheduleAppointment(String date){
		System.out.println("Appointment Date: "+date);
	}
}
class Patient extends Person{
	private int patientID;
	private String pName, medicalConditions;
	Patient(int patientID, String name, String medicalConditions){
		this.patientID = patientID;
		this.name = name;
		this.medicalConditions = medicalConditions;
	}
	public int getPatientId(){
		return patientID;
	}
	public String getPatientName(){
		return pName;
	}
	public String getMedicalConditions(){
		return  medicalConditions;
	}
	public void scheduleAppointment(String date){
		System.out.println("Appointment Date: "+date);
	}
}

class  HospitalManagementSystem
{
	public static void main(String[] args) 
	{
		//Date d = new Date("13-Nov-2024");//(int year, int month, int date)
		Patient p1 = new Patient(101, "Madhuri", "Knee Pain");
		Doctor d1 = new Doctor("Dr.Sushant", 40, "M.D.");
		Nurse n1 = new Nurse("Mayuri", 25, 100);
		MedicalStaff m1 = new MedicalStaff(101, "Aniket","Compunder");
		
		p1.scheduleAppointment("13-Nov-2024");
		//d1.scheduleAppointment("13-Nov-2024");
		//n1.scheduleAppointment("13-Nov-2024");
		
		EmergencyDepartment e1 = new EmergencyDepartment();
		GeneralWard g1 = new GeneralWard();
		System.out.println();
		e1.addStaff(m1);
		System.out.println();
		//e1.removeStaff(m1);
		//System.out.println();
		//g1.addStaff(m1);
		//System.out.println();
		g1.removeStaff(m1);
	}
}
