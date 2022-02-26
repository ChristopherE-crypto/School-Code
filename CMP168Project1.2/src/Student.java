
public class Student extends Person{//Original student. works.
	private static int numStudents;
	private int studentID;
	private Course [] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
	public Student() {
		super();
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		isGraduate = false;
		major = "undeclared";
		studentID = ++numStudents;
	}
	
	public Student(boolean isGraduate) {
		super();
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		major = "undeclared";
		studentID = ++numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		super();
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		studentID = ++numStudents;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		studentID = ++numStudents;
	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {
		if(numCoursesTaken < coursesTaken.length && course != null) {
			coursesTaken[numCoursesTaken] = course;
			numCoursesTaken++;
		}
	}
	
	public void addCoursesTaken(Course [] course) {
		if(numCoursesTaken < coursesTaken.length && course != null) {
			for(int i = 0, j = 0; i < coursesTaken.length && j < course.length; i++) {
				if(coursesTaken[i] == null) {
					addCourseTaken(course[j++]);
				}
			}
		}
	}
	
	public Course getCourseTaken(int index) {
		if(index >= 0 && index < numCoursesTaken) {
			return coursesTaken[index];
		}
		else {
			return null;
		}
	}
	
	public String getCourseTakenAsString(int index) {
		if(index >= 0 && index < numCoursesTaken) {
			return coursesTaken[index].getCourseDept() + "-" + coursesTaken[index].getCourseNum();
		}
		else {
			return "";
		}
	}
	
	public String getAllCoursesTakenAsString() {
		String courses = "";
		for(int i = 0; i < numCoursesTaken; i++) {
			courses += getCourseTakenAsString(i) + ", ";
		}
		return courses;
	}
	
	private boolean compareArrays(Object [] arr, Object [] arr2) {
		boolean equals = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == arr2[i]) {
				equals = true;
			}
			else {
				equals = false;
			}
		}
		return equals;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(this == obj) {return true;}
		if(obj instanceof Student) {
			Student otherS = (Student)obj;
			if(super.equals(otherS)) {
				if(major.equals(otherS.major)) {
					if(isGraduate == otherS.isGraduate) {
						if(numCoursesTaken == otherS.numCoursesTaken) {
							if(compareArrays(this.coursesTaken, otherS.coursesTaken)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public String toString() {
		String is = "Graduate";
		String isNot = "Undergraduate";
		if(isGraduate) {
			return super.toString() + String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, is, numCoursesTaken, getAllCoursesTakenAsString());
		}
		else {
			return super.toString() + String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, isNot, numCoursesTaken, getAllCoursesTakenAsString());
		}
	}
	
	public int compareTo(Person p) {
		int parentVal = super.compareTo(p);
		if(p instanceof Student) {
			
			int totalCredits = 0;
			int totalCredits2 = 0;
			
			for(int i = 0; i < getNumCoursesTaken(); i++) {
				totalCredits += this.getCourseTaken(i).getNumCredits();
			}
			
			for(int i = 0; i < ((Student)p).getNumCoursesTaken(); i++) {
				totalCredits2 += ((Student)p).getCourseTaken(i).getNumCredits();
			}
			if(parentVal > 0) {
				if(totalCredits > totalCredits2) {
					return 1;
				}
			}
			else if(parentVal < 0) {
				if(totalCredits < totalCredits2) {
					return -1;
				}
			}	
			return 0;
			
			
			
			//if(parentVal > 0) {
			//	if(this.getNumCoursesTaken() > ((Student)p).getNumCoursesTaken()) {
			//		return 1;
			//	}
			//}
			//else if(parentVal < 0) {
			//	if(this.getNumCoursesTaken() < ((Student)p).getNumCoursesTaken()) {
			//		return -1;
			//	}
			//}
			//return 0;
		}
		return parentVal;
	}

}
