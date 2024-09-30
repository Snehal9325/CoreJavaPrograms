/*
3. Employee Management System:
Scenario: Build an employee management system to manage employee records within a company.
Requirements:

Encapsulation: Define an Employee class with private fields for attributes such as employee ID, name, and salary. Provide public methods to get and set these fields.
Inheritance: Create a base class Employee and extend it to define FullTimeEmployee and PartTimeEmployee classes. FullTimeEmployee might include attributes 
like annual bonus, while PartTimeEmployee includes attributes like hourly rate.
Polymorphism: Implement a method calculateAnnualBonus() in the Employee class. Override this method in FullTimeEmployee to calculate the bonus based 
on a fixed percentage and in PartTimeEmployee based on hours worked.
Abstraction: Define an abstract class Payroll with abstract methods calculateSalary() and generatePaySlip(). Create a concrete class MonthlyPayroll that 
extends Payroll and implements these methods for generating monthly salary calculations and pay slips.

*/
class Employee{
	private int id;
	private String name;
	private double salary;
	Employee(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public double getSalary(){
		return salary;
	}
	public void calculateAnnualBonus() {
		System.out.println("Employee Id: "+id);
		System.out.println("Employee Name: "+name);
		System.out.println("Employee Salary: "+salary);
	}
}
class FullTimeEmployee extends Employee{
		double per;
		FullTimeEmployee(int id, String name, double salary, double per){
			super(id, name, salary);
			this.per = per;
		}
		@Override
		public void calculateAnnualBonus() {
		//System.out.println("Total Monthly Salary with Bonus: "+(getSalary()*(per/100)));
		System.out.println("Total Annual Salary with Bonus: "+(getSalary()*(per/100)*12));
		}
		public String toString(){
			return "*******************Full Time Employee Details*************************"+"\nEmployee Id: "+getId()+"\nEmployee Name: "+getName()+"\nEmployee Salary: "+getSalary();
		}
}

class PartTimeEmployee extends Employee{
	double hourlyRate;
	PartTimeEmployee(int id, String name, double salary, double hourlyRate){
			super(id, name, salary);
			this.hourlyRate = hourlyRate;
		}
		public String toString(){
			return "*******************Part Time Employee Details*************************"+"\nEmployee Id: "+getId()+"\nEmployee Name: "+getName()+"Employee Salary: "+getSalary();
		}
	@Override
		public void calculateAnnualBonus() {
		System.out.println("Total  Salary : "+(getSalary()*hourlyRate));
		}
}
abstract class Payroll{
	public abstract void calculateSalary(Employee e);
	public abstract void generatePaySlip(Employee e);
}

class MonthlyPayroll extends Payroll{
	public void calculateSalary(Employee e){
			if(e instanceof FullTimeEmployee){
				e.calculateAnnualBonus(); 
			}
			else if(e instanceof PartTimeEmployee){
					e.calculateAnnualBonus() ;
			}
	}
	public void generatePaySlip(Employee e){
		if(e instanceof FullTimeEmployee){
				e.calculateAnnualBonus(); 
			}
			else if(e instanceof PartTimeEmployee){
					e.calculateAnnualBonus() ;
			}
	}
}

class  EmployeeManagementSystem
{
	public static void main(String[] args) 
	{
		FullTimeEmployee f1 = new FullTimeEmployee(101, "Snehal", 50000, 20);
		PartTimeEmployee p1 = new PartTimeEmployee(10, "Sakhi", 40000, 3);
		MonthlyPayroll m1 = new MonthlyPayroll();
		System.out.println(f1);
		m1.calculateSalary(f1);
		m1.generatePaySlip(f1);
		System.out.println();
		System.out.println(p1);
		m1.calculateSalary(p1);
		m1.generatePaySlip(p1);
	}
}
