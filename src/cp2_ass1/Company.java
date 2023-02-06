/*Name: Lazo Ali
 * id: 202105491
 * Last Modified: Feb-6-2022
 * Code Description: Defines a class Manager that is a child to class Employee
 * Files: Emloyee.java, Manager.java
 */
package cp2_ass1;

import java.util.Scanner;

public class Company {
	
	private static int counter = 0;
	private String name;
	private Employee[] employees;
	
	public Company(String n, int size) {
		name = n; employees = new Employee[size];
	}
	
	public int searchForEmployee(String fn) {
	// takes a string for name and returns the index of that name in the array employees.
		
		for(int i = 0; i<employees.length; i++) {
			
			if(employees[i] !=null && employees[i].getFullName().equals(fn)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	public boolean searchValidation(int i) {
	//returns a boolean depending on whether the result of method searchforEmployee() exists or not.
		
		if(i==-1){
			return false;
		}else {return true;}
	
	}
	
	public void ensureCapacity() {
	//checks if the array of employees has filled and creates a new array (old + 10) and transfers all items.
		
		if(employees.length == counter) {
			Employee[] newE = new Employee[employees.length + 10];
			for(int i = 0; i<employees.length; i++) {
				newE[i] = employees[i];
			}
			employees = newE;
		}
		
	}
	
	public void addEmployee() {
	/*inputs attributes of employee
	 * two variables emerge
	 * 	a: whether the user inputed a first name only or a first name and a family name
	 * 	b: whether the added employee is  a manager or not
	 * 4 cases emerge and each case is handled accordingly
	 *  
	 */
		Scanner input = new Scanner(System.in);
		
		System.out.println("_________________");
		System.out.println("Add Employee");
		System.out.println("_________________");
		
		ensureCapacity();
		
		String[] full_name = inputName(",");//gets full name separated by a comma
		
		System.out.println("Enter Hire Date (MM-DD-YY): ");
		String hd = input.nextLine();
		input.nextLine();
		
		
		System.out.println("Enter Salary: ");
		double s = input.nextDouble();
		input.nextLine();
		
		System.out.println("Manager? (Y/N): ");
		String status = input.nextLine();
		input.nextLine();
		
		Employee e = null; // creates an employee
		
		//4 cases
		//1. if employee and full name
		if(full_name.length == 2 && status.equals("N")) {
			
			e = new Employee(full_name[0], full_name[1], hd, s);
			
		//2. if employee and first name only
		}else if(full_name.length == 1 && status.equals("N")) {
			
			e = new Employee(full_name[0], hd, s);

		//3. if manager and full name
		}else if(full_name.length == 2 && status.equals("Y")) {
			
			System.out.println("Sectrary Name: ");
			String secretary = input.nextLine();
			input.nextLine();
			
			e = new Manager(full_name[0], full_name[1], hd, s, secretary);

		//4. manager and first name only
		}else if(full_name.length == 1 && status.equals("Y")) {
			
			System.out.println("Secretary Name: ");
			String secretary = input.nextLine();
			input.nextLine();
			
			e = new Manager(full_name[0], hd, s, secretary);
			
		}else{return;}
		// the created employee above is searched for 
		int index = searchForEmployee(e.getFullName());
		
		//if it was already there user is warned for duplicates
		if(searchValidation(index)) {
			
			System.out.println("Employee already exists!");
			
			return;
			
		// if it wasn't already there it's added
		}else {
			employees[counter] = e;
			System.out.println("Employee added succesfully!");
			counter ++;}

		
		
		
	}
	
	private String[] inputName(String n) {
		// inputs a string from user and splits it by String n and returns an array of the tokens
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Full Name Separated by a (" + n + "): \n");
		
		String[] full_name = input.nextLine().split(n);
		input.nextLine();
		
		return full_name;
		
	}

	public void listAll() {
	//goes through the array of employees up to the counter and prints every employee
		for(int j = 0; j < counter; j++) {
			
			System.out.println(employees[j]);
		}
	}
	
	public void deleteEmployee() {
	/*asks the user for the name of an employee
	 * if it exists it switches with the last item in the array 
	 * then the last item in the array is turned into null  
	 
	 */
		Scanner input = new Scanner(System.in);
		
		System.out.println("_________________");
		System.out.println("Delete Employee");
		System.out.println("_________________");
		
		String[] full_name = inputName(",");
		
		int index; 
		
		if(full_name.length == 2) {
			
			index = searchForEmployee(full_name[0] + " " + full_name[1]);

		}else if(full_name.length == 1) {
			
			index = searchForEmployee(full_name[0] + " ");
		}else {
			return;
		}
	
		if(searchValidation(index)) {
			employees[index] = employees[counter];
			employees[counter] = null;
			counter--;
			System.out.println("Employee deleted successfully!");
		}else {System.out.println("Employee does not exist!");}
		
		
		
				
		
	}
	
	public void raiseSalary() {
	/*inputs employee name and percentage and 2 cases emerge:
	 * 	1. if employee salary is raised by percentage
	 * 	2. if manager salary is raised by percentage and then the salary is raised by bonus 
	 * 
	 */
		Scanner input = new Scanner(System.in);

		System.out.println("_________________");
		System.out.println("Raise Salary");
		System.out.println("_________________");
		
		String[] full_name = inputName(",");
		
		System.out.println("Enter the percentage by which you wish to increase the salary of this employee: (x  not x%) ");
		//convert the percentage to a decimal and add 1 to indicate percent increase
		int	percentage_increase = 1 + (input.nextInt()/100);
		
		int index; 
		
		if(full_name.length == 2) {
			
			index = searchForEmployee(full_name[0] + " " + full_name[1]);

		}else if(full_name.length == 1) {
			
			index = searchForEmployee(full_name[0] + " ");
		}else {
			return;
		}	
		if(searchValidation(index)==false) {
			System.out.println("Employee doesn't exist!");
			return;
		}
		
		Employee e = employees[index];
		
		if(e instanceof Manager) {
			
			e.setSalary(e.getSalary()*percentage_increase);
			
			//calculate the percent increase for the bonus (1+decimal)
			int bonus_percentage_increase = 1 + (((Manager) e).getBonus()/100);
			
			//increase the new salary by the bonus percentage
			e.setSalary(e.getSalary()*bonus_percentage_increase);
			
			System.out.println("Salary increased for manager including bonus!");
			
			
		}else {
			//sets the salary to the previous salary times the percentage increase
			e.setSalary(e.getSalary()*percentage_increase);
			
			System.out.println("Salary increased for employee!");
		}

		
		
		
	}
	
	public void menu() {
	/* displays a menu and asks user for an option
	 * if the option isn't 1-5 user is prompted again up to 5 times
	 * each option from 1-5 calls a specific function
	 * repeats this until user enters 5
	 * 
	 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("_____________________\n"
				+ "1. Add Employee\n"
				+ "2.Delete Employee\n"
				+ "3. Raise Salary\n"
				+ "4. List All\n"
				+ "5. Exit\n"
				+ "_______________________");
		
		int option = input.nextInt();
		int error = 0;
		
		//while the number is not from 1-5 and we haven't repeated this 4 more times
		while((option >= 1 && option <= 5) == false && (error < 4)) {
			
			
			error++;
			System.out.println("Nonexistent option, try again: ");
			option = input.nextInt();
			

			
		}
		
		//while the user didn't enter 5 and didn't enter a nonexistent option for 5 times
		while((option != 5 && error<5)) {
			
			
			if(option == 1) {
				
				addEmployee();
				
			}else if(option == 2) {
				
				deleteEmployee();
				
			}else if(option == 3) {
				
				raiseSalary();
				
			}else if(option == 4) {
				
				listAll();
				
			}else {
				break;
			}
			
			
			
			System.out.println("1. Add Employee\n"
					+ "2.Delete Employee\n"
					+ "3. Raise Salary\n"
					+ "4. List All\n"
					+ "5. Exit\n"
					+ "_______________________");
			
			option = input.nextInt();
		}
		
		
	// after all of the above if the program is ended for any reason tell user
		//if it was because of too many wrong entries tell the user
		if(error==4) {
			System.out.println("Too many wrong entries.");
		}
		System.out.println("Program ended!");
		return;
		
	}
	
	public static void main(String[] concs) {
	
		Company c = new Company("Lazo Corp.", 2);
		c.menu();
	          

		}
		
	}


