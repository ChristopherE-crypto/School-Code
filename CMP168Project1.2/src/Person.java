//This class is fine.
public class Person {
	private String name;
	private int birthYear;
	
	public Person() {
		name = "";
		birthYear = 0;
	}
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(this == obj) {return true;}
		if(obj instanceof Person) {
			Person otherP = (Person) obj;
			if(name.equals(otherP.name)) {
				if(birthYear == otherP.birthYear) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
	}
	
	public int compareTo(Person p) {
		if(this.birthYear > p.birthYear) {
			return 1;
		}
		if(this.birthYear < p.birthYear) {
			return -1;
		}
			return 0;
	}
}
