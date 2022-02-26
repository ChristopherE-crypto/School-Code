import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Testing {
	
	public static void main(String [] args) {
		
		File file = new File("C:/Users/epicd/OneDrive/Desktop/hw/Sentences_homework.txt");
		String fileContent = "";
		
		try {
			Scanner scnr = new Scanner(file);
			while(scnr.hasNextLine()) {
				fileContent = fileContent.concat(scnr.nextLine() + "\n");
			}
			
			FileWriter writer = new FileWriter("C:/Users/epicd/OneDrive/Desktop/hw/Sentences_homework.txt");
			writer.write(fileContent);
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
