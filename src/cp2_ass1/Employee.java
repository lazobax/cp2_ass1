package cp2_ass1;

public class Employee {
	
	//Declaring attributes of the class
	
	protected String firstName;
	protected String familyName;
	protected String hireDay;
	protected double salary;
	
	
	//constructor method
	public Employee(String fn, String ln, String hd, double s) {
		firstName = fn; familyName = ln; hireDay = hd; salary = s;
	}
	
	//string representation method
	public String toString() {
		return firstName + " " + familyName;
	}
	
	//equality method
	public Boolean equals(Employee e){
		//equal if full names are the same
		if(firstName.equals(e.getFirstName())&&
				familyName.equals(e.getFamilyName())) {
			return true;
		}else {
			return false;
					}
	}
	
	//getter methods
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public String getFullName() {
		return firstName + " " + familyName;
	}
	
	public String getHireDay() {
		return hireDay;
	}
	
	public double getSalary() {
		return salary;
	}
	
	//setter methods
	
	public void setFirstName(String n) {
		firstName = n;
	}
	
	public void setLastName(String n) {
		familyName = n;
	}
	
	public void setHireDay(String h) {
		hireDay = h;
	}
	
	public void setSalary(double d) {
		salary = d;
	}
	
	
	

}
