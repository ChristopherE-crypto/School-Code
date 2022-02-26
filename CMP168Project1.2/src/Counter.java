import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Counter {

	public static void main(String[] args) {
		
		Course c1 = new Course(false, 121, "ENG", 4);
		Course c2 = new Course(false, 233, "MAT", 6);
		
		Student2 s1 = new Student2("Chris", 2002, "CS", false);
		Student2 s2 = new Student2("Joseph", 2004, "IDK", false);
		
		s1.addCourseTaken(c1);
		s2.addCourseTaken(c2);
		
		System.out.println(s1.compareTo(s2));

	}

}
