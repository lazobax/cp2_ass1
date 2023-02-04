package cp2_ass1;

public class Manager extends Employee{
	
	private String secretary;
	private static int bonus = 2;
	
	public Manager(String fn, String ln, String hd, double s, String sec) {
		super(fn, ln, hd, s); secretary = sec;
	}
	
	public Manager(String fn, String hd, double s, String sec) {
		super(fn, hd, s); secretary = sec;
	}
	

	public String getSecretary() {
		return secretary;
	}

	public void setSecretary(String s) {
		this.secretary = s;
	}
	
	

}
