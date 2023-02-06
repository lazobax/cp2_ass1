/*Name: Lazo Ali
 * id: 202105491
 * Last Modified: Feb-6-2022
 * Code Description: Defines a class Manager that is a child to class Employee
 * Files: Manager.java, Company.java
 */
package cp2_ass1;

public class Employee {
	
	//Declaring attributes of the class
	
	protected String first_name;
	protected String family_name = "";
	protected String hire_day;
	protected double salary;
	
	
	//constructor method
	public Employee(String fn, String ln, String hd, double s) {
		first_name = fn; family_name = ln; hire_day = hd; salary = s;
	}
	
	public Employee(String fn, String hd, double s) {
		first_name = fn; hire_day = hd; salary = s;

	}
	
	//string representation method
	public String toString() {
		return first_name + " " + family_name;
	}
	
	//equality method
	public Boolean equals(Employee e){
		//equal if full names are the same
		if(first_name.equals(e.getFirstName())&&
				family_name.equals(e.getFamilyName())) {
			return true;
		}else {
			return false;
					}
	}
	
	//getter methods
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getFamilyName() {
		return family_name;
	}
	
	public String getFullName() {
		return first_name + " " + family_name;
	}
	
	public String getHireDay() {
		return hire_day;
	}
	
	public double getSalary() {
		return salary;
	}
	
	//setter methods
	
	public void setFirstName(String n) {
		first_name = n;
	}
	
	public void setLastName(String n) {
		family_name = n;
	}
	
	public void setHireDay(String h) {
		hire_day = h;
	}
	
	public void setSalary(double d) {
		salary = d;
	}
	
	
	

}
