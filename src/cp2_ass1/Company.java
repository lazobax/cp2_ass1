package cp2_ass1;

import java.util.Scanner;

public class Company {
	
	static int counter = 0;
	private String name;
	public Employee[] employees;
	
	public Company(String n, int size) {
		name = n; employees = new Employee[size];
	}
	
	int searchForEmployee(String fn) {
		
		
		for(int i = 0; i<employees.length; i++) {
			if(employees[i] !=null && employees[i].toString().equals(fn)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	boolean searchValidation(int i) {
		if(i==-1){
			return false;
		}else {return true;}
	
	}
	
	void ensureCapacity() {
		if(employees.length == counter) {
			Employee[] newE = new Employee[employees.length + 10];
			for(int i = 0; i<employees.length; i++) {
				newE[i] = employees[i];
				employees = newE;
			}
		}
		
	}
	
	public void addEmployee() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("_________________");
		System.out.println("Add Employee");
		System.out.println("_________________");
		
		ensureCapacity();
		
		System.out.println("Enter Full Name Separated by a Comma (First,Last): \n");
		// tokenize the string input
		String[] full_name = input.nextLine().split(",");
		input.nextLine();
		
		
		
		System.out.println("Enter Hire Date (MM-DD-YY): ");
		String hd = input.nextLine();
		input.nextLine();
		
		
		System.out.println("Enter Salary: ");
		double s = input.nextDouble();
		input.nextLine();
		
		System.out.println("Manager? (Y/N): ");
		String status = input.nextLine();
		input.nextLine();
		
		Employee e = null;
		
		//if employee and full name
		if(full_name.length == 2 && status.equals("N")) {
			
			e = new Employee(full_name[0], full_name[1], hd, s);
			
		//if employee and first name only
		}else if(full_name.length == 1 && status.equals("N")) {
			
			e = new Employee(full_name[0], hd, s);

		//if manager and full name
		}else if(full_name.length == 2 && status.equals("Y")) {
			
			System.out.println("Sectrary Name: ");
			String secretary = input.nextLine();
			input.nextLine();
			
			e = new Manager(full_name[0], full_name[1], hd, s, secretary);

		//otherwise (manager and first name only) 
		}else if(full_name.length == 1 && status.equals("Y")) {
			
			System.out.println("Secretary Name: ");
			String secretary = input.nextLine();
			input.nextLine();
			
			e = new Manager(full_name[0], hd, s, secretary);
			
		}else{return;}
		
				
		int index = searchForEmployee(full_name[0]+" "+full_name[1]);
		
		if(searchValidation(index)) {
			
			System.out.println("Employee already exists!");
			
			return;
			
		}
		
		
		employees[counter] = e;
		System.out.println("Employee added succesfully!");
		counter ++;

		
		
		
	}
	
	public void listAll() {
		for(int j = 0; j < employees.length; j++) {
			if(employees[j] != null) {
				System.out.println(employees[j]);
			}
		}
	}
	
	public void deleteEmployee() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("_________________");
		System.out.println("Delete Employee");
		System.out.println("_________________");
		
		System.out.println("Enter First Name: \n");
		String n = input.nextLine();
		input.nextLine();
		
		System.out.println("Enter Family Name: \n");
		String fn = input.nextLine();
		input.nextLine();
		
		int index = searchForEmployee(n + " " + fn);
	
		if(searchValidation(index)) {
			employees[index] = employees[counter];
			employees[counter] = null;
			counter--;
		}else {System.out.println("Employee does not exist!");}
		
		
		
				
		
	}
	
	public void raiseSalary() {
		
	}
	
	
	public static void main(String[] concs) {
	
		Company c = new Company("Jef", 25);
		
		while(true) {
			c.addEmployee();
		}

		}
		
	}


