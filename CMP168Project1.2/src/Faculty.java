//Class op. This one works.
public class Faculty extends Employee{
	private Course [] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	public Faculty() {
		super();
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		isTenured = false;
	}
	
	public Faculty(boolean isTenured) {
		super();
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public Faculty(String deptName, boolean isTenured) {
		super(deptName);
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear, deptName);
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public boolean isTenured() {
		return isTenured;
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	public void addCourseTaught(Course course) {
		if(numCoursesTaught < coursesTaught.length && course != null) {
			coursesTaught[numCoursesTaught] = course;
			numCoursesTaught++;
		}
	}
	
	public void addCoursesTaught(Course [] course) {
		if(numCoursesTaught < coursesTaught.length && course != null) {
			for(int i = 0, j = 0; i < coursesTaught.length && j < course.length; i++) {
				if(coursesTaught[i] == null) {
					addCourseTaught(course[j++]);
				}
			}
		}
	}
	
	public Course getCourseTaught(int index) {
		if(index >= 0 && index < numCoursesTaught) {
			return coursesTaught[index];
		}
		else {
			return null;
		}
	}
	
	public String getCourseTaughtAsString(int index) {
		if(index >= 0 && index < numCoursesTaught) {
			return coursesTaught[index].getCourseDept() + "-" + coursesTaught[index].getCourseNum();
		}
		else {
			return "";
		}
	}
	
	public String getAllCoursesTaughtAsString() {
		String courses = "";
		for(int i = 0; i < numCoursesTaught; i++) {
			courses += getCourseTaughtAsString(i) + ", ";
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
		if(obj instanceof Faculty) {
			Faculty otherF = (Faculty) obj;
			if(super.equals(otherF)) {
				if(numCoursesTaught == otherF.numCoursesTaught) {
					if(isTenured == otherF.isTenured) {
						if(compareArrays(this.coursesTaught, otherF.coursesTaught)){
							return true;
							}
						}
					}
				}
			}
		return false;
	}
	
	public String toString() {
		if(isTenured) {
			return super.toString() + String.format(" Faculty:  Is Tenured | Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
		}
		else {
			return super.toString() + String.format(" Faculty: Not Tenured | Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
		}
	}
	
	public int compareTo(Person p) {
		int parentVal = super.compareTo(p);
		if(p instanceof Faculty) {
			if(parentVal > 0) {
				if(this.numCoursesTaught > ((Faculty)p).numCoursesTaught) {
					return 1;
				}
			}
			else if(parentVal < 0) {
				if(this.numCoursesTaught < ((Faculty)p).numCoursesTaught) {
					return -1;
				}
			}
			return 0;
		}
		return parentVal;
	}

}
