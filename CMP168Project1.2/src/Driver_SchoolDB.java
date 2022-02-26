import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver_SchoolDB {//Youtube video: https://www.youtube.com/watch?v=9lT778BMy2M The audio is a bit low, recommend using headphones.
	
	public static void main(String [] args) {
		String path = "SchoolDB_Initial.txt";
		String line = "";
		String text = "";
		String [] courseInfo = new String [5];
		String [] facultyInfo = new String [5];
		String [] studentInfo = new String [5];
		String [] generalStaffInfo = new String [5];
		ArrayList <Course> courseList = new <Course> ArrayList();
		ArrayList <Faculty> facultyList = new <Faculty> ArrayList();
		ArrayList <Student> studentList = new <Student> ArrayList();
		ArrayList <GeneralStaff> generalStaffList = new <GeneralStaff> ArrayList();
		File file = new File(path);
		Scanner scnr = null;
		Scanner output = null;
		
		try {
			scnr = new Scanner(file);
			while(scnr.hasNext()) {
				line = scnr.nextLine();
				line = line.replace(':', ',');
				line = line.replaceAll(" ", "");
				
				if(line.startsWith("Course")) {
					courseInfo = line.split(",");
					for(int i = 0; i < 1; i++) {
						courseList.add(i, new Course(Boolean.parseBoolean(courseInfo[1]), Integer.parseInt(courseInfo[2]), courseInfo[3], Integer.parseInt(courseInfo[4])));
					}
					
					
				}
				
				if(line.startsWith("Faculty")) {
					facultyInfo = line.split(",");
					if(facultyInfo.length == 1) {
						facultyList.add(new Faculty());
					}
					if(facultyInfo.length == 2) {
						for(int i = 0; i < 1; i++) {
							facultyList.add(i, new Faculty(Boolean.parseBoolean(facultyInfo[1])));
						}
					}
					if(facultyInfo.length == 3) {
						for(int i = 0; i < 1; i++) {
							facultyList.add(i, new Faculty(facultyInfo[1], Boolean.parseBoolean(facultyInfo[2])));
						}
					}
					if(facultyInfo.length == 5) {
						for(int i = 0; i < 1; i++) {
							facultyList.add(i, new Faculty(facultyInfo[1], Integer.parseInt(facultyInfo[2]), facultyInfo[3], Boolean.parseBoolean(facultyInfo[4])));
						}
					}
					
				}
				
				if(line.startsWith("Student")) {
					studentInfo = line.split(",");
					if(studentInfo.length == 1) {
						studentList.add(new Student());
					}
					if(studentInfo.length == 2) {
						for(int i = 0; i < 1; i++) {
							studentList.add(i, new Student(Boolean.parseBoolean(studentInfo[1])));
						}
					}
					if(studentInfo.length == 3) {
						for(int i = 0; i < 1; i++) {
							studentList.add(i, new Student(studentInfo[1], Boolean.parseBoolean(studentInfo[2])));
						}
					}
					if(studentInfo.length == 5) {
						for(int i = 0; i < 1; i++) {
							studentList.add(i, new Student(studentInfo[1], Integer.parseInt(studentInfo[2]), studentInfo[3], Boolean.parseBoolean(studentInfo[4])));
						}
					}
				}
				
				if(line.startsWith("GeneralStaff")) {
					generalStaffInfo = line.split(",");
					if(generalStaffInfo.length == 1) {
						generalStaffList.add(new GeneralStaff());
					}
					if(generalStaffInfo.length == 2) {
						generalStaffInfo[1] = "advise students";
						for(int i = 0; i < 1; i++) {
							generalStaffList.add(i, new GeneralStaff(generalStaffInfo[1]));
						}
					}
					if(generalStaffInfo.length == 3) {
						for(int i = 0; i < 1; i++) {
							generalStaffList.add(i, new GeneralStaff(generalStaffInfo[1], generalStaffInfo[2]));
						}
					}
					if(generalStaffInfo.length == 5) {
						generalStaffInfo[1] = "Flash Gordon";
						for(int i = 0; i < 1; i++) {
							generalStaffList.add(i, new GeneralStaff(generalStaffInfo[1], Integer.parseInt(generalStaffInfo[2]), generalStaffInfo[3], generalStaffInfo[4]));
						}
					}
				}
				
				
			}
			//Output the file and all the stuff!
			File file2 = new File("SchoolDB_Initial.txt");
			output = new Scanner(file2);
			
			while(output.hasNext()) {
				text = output.nextLine();
				System.out.println(text);
			}
			
			System.out.println();
			System.out.println("**************************************************************");
			System.out.println("SCHOOL DATABASE INFO:");
			System.out.println();
			System.out.println("************************************************");
			System.out.println("COURSES:");
			System.out.println(courseList.get(5));
			System.out.println(courseList.get(4));
			System.out.println(courseList.get(3));
			System.out.println(courseList.get(2));
			System.out.println(courseList.get(1));
			System.out.println(courseList.get(0));
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("PERSONS:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("EMPLOYEES:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("GENERAL STAFF:");
			System.out.println(generalStaffList.get(3));
			System.out.println(generalStaffList.get(2));
			System.out.println(generalStaffList.get(1));
			System.out.println(generalStaffList.get(0));
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("FACULTY:");
			System.out.println(facultyList.get(3));
			System.out.println(facultyList.get(2));
			System.out.println(facultyList.get(1));
			System.out.println(facultyList.get(0));
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("STUDENTS:");
			System.out.println(studentList.get(3));
			System.out.println(studentList.get(2));
			System.out.println(studentList.get(1));
			System.out.println(studentList.get(0));
			System.out.println("************************************************");
			System.out.println("**************************************************************");
			System.out.println();
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			scnr.close();
			output.close();
			
		}
		
		
		
	}

}
/*CODE FOR THE MENU
 * public class Menu {
	
	public static void writeToNewFile(String fileName, String text) {//Based on Prof. Sofiano's source code.
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName, true));
			outStream.write(text);
		} catch(FileNotFoundException e) {
			System.err.println("File Not Found " + e.getMessage());
		}
		finally {
			if(outStream != null) {
				outStream.close();
			}
		}
	}
	
	public static int mainMenu(Scanner scnr) {
		System.out.println("**************************************************************");
		System.out.println("Please select on the the options above by entering a number 1-15 (Enter -1 to exit):");
		System.out.println("1.Create a new Course object\n2.Create a new Faculty object\n3.Create a new GeneralStaff object\n4.Create a new Student object");
		System.out.println("5.Add a new Course to a Faculty object\n6.Add a new Course to a Student object\n7.Add an array of 2 Courses to a Faculty Object\n8.Add an array of 2 Courses to a Student object");
		System.out.println("9.Get the Course at index from a Faculty object\n10.Get the Course at index from a Student object");
		System.out.println("11.Select a Faculty object and a Course object and query the Faculty object for the Course to determine whether the Faculty object teaches it or not");
		System.out.println("12.Determine which Faculty object teaches the most and least courses\n13.Determine which Course is the minimum of all Course objects in the catalog");
		System.out.println("14.Determine which Course is the maximum of all Course objects in the catalog\n15.Detemine which student has the most and least credits");
		System.out.println("After you are done creating the objects, enter 0 to print all the infomation...");
		System.out.println("**************************************************************");
		int choice = scnr.nextInt();
		return choice;
	}
	public static void main(String [] args) {	
		String text = "";
		ArrayList <Course> courses = new ArrayList <Course>();
		ArrayList <Course> allCourses = new ArrayList <Course>();
		ArrayList <Faculty> faculties = new ArrayList <Faculty>();
		ArrayList <GeneralStaff> generalStaff = new ArrayList <GeneralStaff>();
		ArrayList <Student> students = new ArrayList <Student>();
		Course [] coursesToAddF = new Course[2];
		Course [] coursesToAddS = new Course[2];
		Scanner scnr = new Scanner(System.in);
		System.out.println("**************************************************************");
		System.out.println("Welcome to the School Data Base");
		while(true) {
			int choice = mainMenu(scnr);
			if(choice == -1) {
				System.out.println("See you soon, good bye!");
				System.exit(0);
				break;
			}
			if(choice == 1) {
				System.out.println("Enter the information for the course: ");
				System.out.println("Is this a graduate course? (true/false):");
				String isGraduate = scnr.next();
				System.out.println("Course number:");
				int courseNum = scnr.nextInt();
				System.out.println("Course department:");
				String courseDept = scnr.next();
				System.out.println("Number of credits:");
				int numCredits = scnr.nextInt();
				Course c1 = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				courses.add(c1);
				allCourses.add(c1);
				
				
			}
			if(choice == 2) {
				System.out.println("Enter the information for the Faculty:");
				System.out.println("Name of faculty:");
				String name = scnr.next();
				System.out.println("Birth year:");
				int birthYear = scnr.nextInt();
				System.out.println("Department name:");
				String deptName = scnr.next();
				System.out.println("Is the Faculty tenured? (true/false)");
				String isTenured = scnr.next();
				Faculty f1 = new Faculty(name, birthYear, deptName, Boolean.parseBoolean(isTenured));
				faculties.add(f1);
				
			}
			if(choice == 3) {
				System.out.println("Enter the information for the GeneralStaff:");
				System.out.println("Name of the generalstaff:");
				String name = scnr.next();
				System.out.println("Birth year:");
				int birthYear = scnr.nextInt();
				System.out.println("Department name:");
				String deptName = scnr.next();
				System.out.println("Duty:");
				String duty = scnr.next();
				GeneralStaff g1 = new GeneralStaff(name, birthYear, deptName, duty);
				generalStaff.add(g1);
				
			}
			if(choice == 4) {
				System.out.println("Enter the information for Student:");
				System.out.println("Student name:");
				String name = scnr.next();
				System.out.println("Birth year:");
				int birthYear = scnr.nextInt();
				System.out.println("Major:");
				String major = scnr.next();
				System.out.println("Is this student graduated? (true/false):");
				String isGraduated = scnr.next();
				Student s1 = new Student(name, birthYear, major, Boolean.parseBoolean(isGraduated));
				students.add(s1);
		       
			}
			if(choice == 5) {
				System.out.println("Select the faculty you wish to add a new course to (0-" + (faculties.size()-1) + "):");
				
				for(int i = 0; i< faculties.size(); i++) {
					System.out.println(faculties.get(i));
				}
			
				int num = scnr.nextInt();
				
				System.out.println("Enter the information for the first course: ");
				System.out.println("Is this a graduate course? (true/false):");
				String isGraduate = scnr.next();
				System.out.println("Course number:");
				int courseNum = scnr.nextInt();
				System.out.println("Course department:");
				String courseDept = scnr.next();
				System.out.println("Number of credits:");
				int numCredits = scnr.nextInt();
				Course courseA = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				faculties.get(num).addCourseTaught(courseA);
				allCourses.add(courseA);
				
			}
			if(choice == 6) {
				System.out.println("Select the Student you wish to add a new course to (0-" + (students.size()-1) + "):");
				
				for(int i = 0; i < students.size(); i++) {
					System.out.println(students.get(i));
				}
				
				int num = scnr.nextInt();
				
				System.out.println("Enter the information for the first course: ");
				System.out.println("Is this a graduate course? (true/false):");
				String isGraduate = scnr.next();
				System.out.println("Course number:");
				int courseNum = scnr.nextInt();
				System.out.println("Course department:");
				String courseDept = scnr.next();
				System.out.println("Number of credits:");
				int numCredits = scnr.nextInt();
				Course courseC = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				students.get(num).addCourseTaken(courseC);
				allCourses.add(courseC);
				
			}
			if(choice == 7) {
				System.out.println("Select the Faculty you wish to add an array of 2 Courses to (0-" + (faculties.size()-1) + "):");
				for(int i = 0; i < faculties.size(); i++) {
					System.out.println(faculties.get(i));
				}
				int num = scnr.nextInt();
				
				System.out.println("Enter the information for the first course: ");
				System.out.println("Is this a graduate course? (true/false):");
				String isGraduate = scnr.next();
				System.out.println("Course number:");
				int courseNum = scnr.nextInt();
				System.out.println("Course department:");
				String courseDept = scnr.next();
				System.out.println("Number of credits:");
				int numCredits = scnr.nextInt();
				Course courseE = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				coursesToAddF[0] = courseE;
				allCourses.add(courseE);
				
				System.out.println("Enter the information for the second course: ");
				System.out.println("Is this a graduate course? (true/false):");
				isGraduate = scnr.next();
				System.out.println("Course number:");
				courseNum = scnr.nextInt();
				System.out.println("Course department:");
				courseDept = scnr.next();
				System.out.println("Number of credits:");
				numCredits = scnr.nextInt();
				Course courseF = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				coursesToAddF[1] = courseF;
				allCourses.add(courseF);
				faculties.get(num).addCoursesTaught(coursesToAddF);
			}
			if(choice == 8) {
				System.out.println("Select the Student you wish to add an array of 2 Courses to (0-" + (students.size()-1) + "):");
				for(int i = 0; i < students.size(); i++) {
					System.out.println(students.get(i));
				}
				
				int num = scnr.nextInt();
				
				System.out.println("Enter the information for the first course: ");
				System.out.println("Is this a graduate course? (true/false):");
				String isGraduate = scnr.next();
				System.out.println("Course number:");
				int courseNum = scnr.nextInt();
				System.out.println("Course department:");
				String courseDept = scnr.next();
				System.out.println("Number of credits:");
				int numCredits = scnr.nextInt();
				
				Course courseG = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				coursesToAddS[0] = courseG;
				allCourses.add(courseG);
				
				System.out.println("Enter the information for the second course: ");
				System.out.println("Is this a graduate course? (true/false):");
				isGraduate = scnr.next();
				System.out.println("Course number:");
				courseNum = scnr.nextInt();
				System.out.println("Course department:");
				courseDept = scnr.next();
				System.out.println("Number of credits:");
				numCredits = scnr.nextInt();
				
				Course courseH = new Course(Boolean.parseBoolean(isGraduate), courseNum, courseDept, numCredits);
				coursesToAddS[1] = courseH;
				allCourses.add(courseH);
				
				students.get(num).addCoursesTaken(coursesToAddS);
				
			}
			
			if(choice == 9) {
				System.out.println("Select the Faculty you wish to get the Course at index from (0-" + (faculties.size()-1) + "):");
				for(int i = 0; i < faculties.size(); i++) {
					System.out.println(faculties.get(i));
				}
				
				int num = scnr.nextInt();
				
				System.out.println("Enter the index of the Course object you want to get (Start at 0):");
				int index = scnr.nextInt();
				
				if(index >= 0 && index < faculties.get(num).getNumCoursesTaught()) {
					faculties.get(num).getCourseTaught(index);
					System.out.println(faculties.get(num).getCourseTaught(index));
				}
				else {
					System.out.println("Invalid index. Course does not exist at such index. Try again please...");
				}
				
			}
			
			if(choice == 10) {
				System.out.println("Select the Student you wish to get the Course at index from (0-" + (students.size()-1) + "):");
				for(int i = 0; i < students.size(); i++) {
					System.out.println(students.get(i));
				}
				
				int num = scnr.nextInt();
				
				System.out.println("Enter the index of the Course object you want to get (Start at 0):");
				int index = scnr.nextInt();
				
				if(index >= 0 && index < students.get(num).getNumCoursesTaken()) {
					students.get(num).getCourseTaken(index);
					System.out.println(students.get(num).getCourseTaken(index));
				}
				else {
					System.out.println("Invalid index. Course does not exist at such index. Try again please...");
				}
			}
			
			if(choice == 11) {
				System.out.println("Select a Faculty object (0-" + (faculties.size()-1) + "):");
				for(int i = 0; i < faculties.size(); i++) {
					System.out.println(faculties.get(i));
				}
				
				int num = scnr.nextInt();
				
				System.out.println("Select a Course object (0-" + (allCourses.size()-1) + ")");
				
				for(int i = 0; i < allCourses.size(); i++) {
					System.out.println(allCourses.get(i));
				}
				
				int num2 = scnr.nextInt();
				
				for(int j = 0; j < faculties.get(num).getNumCoursesTaught(); j++) {
					if(faculties.get(num).getCourseTaught(j).equals(allCourses.get(num2)) == true) {
						System.out.println("The Faculty you selected: " + faculties.get(num).getName() +" teaches the course: " + allCourses.get(num2).getCourseName() + " selected from the menu.");
					}
					else {
						System.out.println("The Faculty: " + faculties.get(num).getName() +" does not teach the course: " + allCourses.get(j).getCourseName() + ".");
					}
				}
			}
			
			if(choice == 12) {
				Faculty fMax = null;
				int max = 0;
				for(int i = 0; i < faculties.size(); i++) {
					if(faculties.get(i).getNumCoursesTaught() > max) {
						fMax = faculties.get(i);
						max = faculties.get(i).getNumCoursesTaught();
					}
				}
				System.out.println("The Faculty that teaches the MOST number of Courses is: ");
				System.out.println(fMax);
				
				Faculty fMin = null;
				int min = 100;
				for(int i = 0; i < faculties.size(); i++) {
					if(faculties.get(i).getNumCoursesTaught() < min) {
						fMin = faculties.get(i);
						min = faculties.get(i).getNumCoursesTaught();
					}
				}
				System.out.println("The Faculty that teaches the LEAST number of Courses is: ");
				System.out.println(fMin);
			}
			
			if(choice == 13) {
				int min = 100;
				Course minC = null;
				for(int i = 0; i < allCourses.size(); i++) {
					if(allCourses.get(i).getNumCredits() < min) {
						min = allCourses.get(i).getNumCredits();
						minC = allCourses.get(i);
					}
				}
				System.out.println("The minimum Course of all Course objects (based on number of credits) is: ");
				System.out.println(minC);
			}
			
			if(choice == 14) {
				int max = 0;
				Course maxC = null;
				for(int i = 0; i < allCourses.size(); i++) {
					if(allCourses.get(i).getNumCredits() > max) {
						max = allCourses.get(i).getNumCredits();
						maxC = allCourses.get(i);
					}
				}
				System.out.println("The maximum Course of all Course objects (based on number of credits) is: ");
				System.out.println(maxC);
				
			}
			if(choice == 15) {
				Student maxS = null;
				Student minS = null;
				
				int maxC = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				
				for(int i = 0; i < students.size(); i++) {
					for(int j = 0; j < students.get(i).getNumCoursesTaken(); i++) {
						if(students.get(i).getCourseTaken(j).getNumCredits() > maxC) {
							maxC = students.get(i).getCourseTaken(j).getNumCredits();
							maxS = students.get(i);
						}
					}
				}
				System.out.println("The Student with the MOST credits is: ");
				System.out.println(maxS);
				
				for(int i = 0; i < students.size(); i++) {
					for(int j = 0; j < students.get(i).getNumCoursesTaken(); i++) {
						if(students.get(i).getCourseTaken(j).getNumCredits() < min) {
							min = students.get(i).getCourseTaken(j).getNumCredits();
							minS = students.get(i);
						}
					}
				}
				System.out.println("The student with the LEAST credits is ");
				System.out.println(minS);
			}
			
			if(choice == 0) {
				System.out.println("**************************************************************");
				System.out.println("SCHOOL DATA BASE INFO:");
				System.out.println();
				System.out.println("************************************************");
				System.out.println("COURSES:");
				for(int i = 0; i < allCourses.size(); i++) {
					System.out.println(allCourses.get(i));
				}
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("PERSONS:");
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("EMPLOYEES:");
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("GENERAL STAFF:");
				for(int j = 0; j < generalStaff.size(); j++) {
					System.out.println(generalStaff.get(j));
				}
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("FACULTY:");
				for(int k = 0; k < faculties.size(); k++) {
					System.out.println(faculties.get(k));
				}
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("STUDENTS:");
				for(int l = 0; l < students.size(); l++) {
					System.out.println(students.get(l));
				}
				System.out.println("************************************************");
				System.out.println("**************************************************************");
				
				
				for(int i = 0; i < allCourses.size(); i++) {
					text += "Course: " + allCourses.get(i).isGraduateCourse() + ", " + allCourses.get(i).getCourseNum() + ", " + allCourses.get(i).getCourseDept() + ", " + allCourses.get(i).getNumCredits() + "\n";
				}
				
				for(int a = 0; a < faculties.size(); a++) {
					text += "Faculty: " + faculties.get(a).getName() + ", " + faculties.get(a).getBirthYear() + ", " + faculties.get(a).getDeptName() + ", " + faculties.get(a).isTenured() + "\n";
				}
				
				for(int b = 0; b < students.size(); b++) {
					text += "Student: " + students.get(b).getName() + ", " + students.get(b).getBirthYear() + ", " + students.get(b).getMajor() + ", " + students.get(b).isGraduate() + "\n";
				}
				
				for(int c = 0; c < generalStaff.size(); c++) {
					text += "GeneralStaff: " + generalStaff.get(c).getName() + ", " + generalStaff.get(c).getBirthYear() + ", " + generalStaff.get(c).getDeptName() + ", " + generalStaff.get(c).getDuty() + "\n";
				}
				
				writeToNewFile("SchoolDB_Output.txt", text);
				
				System.exit(0);
				
			}
			
		}
		
		
		
		
	}

}
 */ 
