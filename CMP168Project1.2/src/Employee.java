//This class is fine.
public class Employee extends Person{
	private String deptName;
	private static int numEmployees;
	private int employeeID;
	
	public Employee() {
		super();
		deptName = "";
		employeeID = ++numEmployees;
	}
	
	public Employee(String deptName) {
		super();
		this.deptName = deptName;
		employeeID = ++numEmployees;
	}
	
	public Employee(String name, int birthYear, String deptName) {
		super(name, birthYear);
		this.deptName = deptName;
		employeeID = ++numEmployees;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(this == obj) {return true;}
		if(obj instanceof Employee) {
			Employee otherE = (Employee) obj;
			if(super.equals(otherE)) {
				if(this.deptName.equals(otherE.deptName)) { 
					return true;		
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
	}
	
	public int compareTo(Person p) {
		int parentVal = super.compareTo(p);
		if(p instanceof Employee) {
			if(parentVal > 0) {
				if(this.getEmployeeID() > ((Employee)p).getEmployeeID()) {
					return 1;
				}
			}
			else if(parentVal < 0) {
				if(this.getEmployeeID() < ((Employee)p).getEmployeeID()) {
					return -1;
				}
			}
			return 0;
		}
		return parentVal;
	}
}
