
public class GeneralStaff extends Employee{
	private String duty;
	
	public GeneralStaff() {
		super();
		duty = "";
	}
	
	public GeneralStaff(String duty) {
		super();
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(this == obj) {return true;}
		if(obj instanceof GeneralStaff) {
			GeneralStaff otherG = (GeneralStaff)obj;
			if(super.equals(otherG)) {
				if(duty.equals(otherG.duty)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + String.format(" GeneralStaff: Duty: %10s", duty);
	}
	
	public int compareTo(Person p) {
		return super.compareTo(p);//FIXME
	}
}
