//This class is fine.
public class Course implements Comparable <Course>{
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	
	public String getCourseName() {
		if(isGraduateCourse) {
			return "G" + getCourseDept() + getCourseNum();
		}
		else {
			return "U" + getCourseDept() + getCourseNum();
		}
	}
	
	@Override
	public boolean equals(Object obj) {//Based on prof Sofianos' source code.
		if(obj == null) {return false;}
		if(this == obj) {return true;}
		if(obj instanceof Course) {
			Course otherC = (Course) obj;
			if(isGraduateCourse == otherC.isGraduateCourse) {
				if(courseNum == otherC.courseNum) {
					if(courseDept.equals(otherC.courseDept)) {
						if(numCredits == otherC.numCredits) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if(isGraduateCourse) {
			return String.format("Course: %3s-%3d | Number of Credits: %02d | Graduate", courseDept, courseNum, numCredits);
		}
		else {
			return String.format("Course: %3s-%3d | Number of Credits: %02d | Undergraduate", courseDept, courseNum, numCredits);
		}
	}

	@Override
	public int compareTo(Course obj) {//Based on prof Sofianos' source code.
		if(courseNum > obj.courseNum) {
			return 1;
		}
		if(courseNum < obj.courseNum) {
			return -1;
		}
		return 0;
	}

}
