import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Testing2 {
	
	public static void main(String [] args) {
		String path = "C:/Users/epicd/OneDrive/Desktop/SchoolDB_Initial.txt";
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
				
				//System.out.println(line);
			}
			System.out.println(courseList.size());
			System.out.println(courseList.toString());
			System.out.println();
			System.out.println(facultyList.size());
			System.out.println(facultyList.toString());
			System.out.println();
			System.out.println(studentList.size());
			System.out.println(studentList.toString());
			System.out.println();
			System.out.println(generalStaffList.size());
			System.out.println(generalStaffList.toString());
			
			File file2 = new File(path);
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
		}
	}
		

	

}
