/*Name: Lazo Ali
 * id: 202105491
 * Last Modified: Feb-6-2022
 * Code Description: Defines a class Manager that is a child to class Employee
 * Files: Emloyee.java, Company.java
 */
package cp2_ass1;

public class Manager extends Employee{
	
	private String secretary;
	private static int BONUS = 2;
	
	public Manager(String fn, String ln, String hd, double s, String sec) {
		super(fn, ln, hd, s); secretary = sec;
	}
	
	public Manager(String fn, String hd, double s, String sec) {
		super(fn, hd, s); secretary = sec;
	}
	
	public String toString() {
		return "M: " + super.toString();
	}
	

	public String getSecretary() {
		return secretary;
	}

	public void setSecretary(String s) {
		this.secretary = s;
	}
	
	public int getBonus() {
		
		return BONUS;
		
	}
	
	

}
