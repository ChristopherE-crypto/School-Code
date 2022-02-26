import java.util.Scanner; //Link for the YouTube video: https://www.youtube.com/watch?v=tWV8tiZdikk
public class ProjectEliza {
	
	public static String word1(String input) {
		if(!input.contains(" ")) {//In case the user enters a single word.
			return input.substring(0, input.length()-1);
		}
		else {
		String word1 = input.substring(0, input.indexOf(' '));
		return word1;
		}
	}
	
	public static String word2(String input) {
		if(!input.contains(" ")) {//In case the user enters a single word.
			return input.substring(0, input.length()-1);
		}
		else {
		String word2 = input.substring(input.lastIndexOf(' ') + 1, input.length()-1);
		return word2;
		}
	}
	
	public static void brain() {
		PromptBank eliza = new PromptBank();
		Scanner scnr = new Scanner(System.in);
		String question = "";
		String statement = "";
		String answer;
		
		
		
		System.out.println("Hello, my name is Eliza. What is your name?");
		String name = scnr.next();
		scnr.nextLine();
		System.out.println("Hello, " + name + ". Tell me what is on your mind today in 1 sentence.");
		
		while(true) {//
		
		String input = scnr.nextLine();
		
		if(input.equalsIgnoreCase("EXIT")) {
			System.out.println("Do you want to run the session again?");
			answer = scnr.next();
			if(answer.equalsIgnoreCase("No")) {
				System.out.println("Goodbye, until next time");
				System.exit(1);
			}
			if(answer.equalsIgnoreCase("Yes")) {
				brain();
			}
		}
		
		
		
		if(input.charAt(input.length()-1) == '?' && !input.equalsIgnoreCase("EXIT")) {//If the user's sentence ends with '?', this block of code is executed.
		 eliza.populateQuestionsArray();	
		 question = eliza.getRandomQuestionTrunk().replaceAll("\\bBLANK2\\b", word2(input));
		 question = question.replaceAll("\\bBLANK1\\b", word1(input));
		 System.out.println(question);
		 
		}
		
		
		if(input.charAt(input.length()-1) == '.' && !input.equalsIgnoreCase("EXIT")) {//If the user's sentence ends with '.', this block of code is executed.
			eliza.populateStatementsArray();
			statement = eliza.getRandomStatementTrunk().replaceAll("\\bBLANK2\\b", word2(input));
			statement = statement.replaceAll("\\bBLANK1\\b", word1(input));
			System.out.println(statement);
			
		}
		
		
		if(input.charAt(input.length()-1) == '!' && !input.equalsIgnoreCase("EXIT")) {//If the user's sentence ends with '!', this block of code is executed.
			eliza.populateStatementsArray();
			statement = "WOW! Dramatic! "+ eliza.getRandomStatementTrunk().replaceAll("\\bBLANK2\\b", word2(input));
			statement = statement.replaceAll("\\bBLANK1\\b", word1(input));
			System.out.println(statement);
			
		}
		
		
		if(input.charAt(input.length()-1) != '?' && input.charAt(input.length()-1) != '!' && input.charAt(input.length()-1) != '.' && !input.equalsIgnoreCase("EXIT")) {//Could have been done with an else statement!
			eliza.populateStatementsArray();
			statement = eliza.getRandomStatementTrunk().replaceAll("\\bBLANK2\\b", input.substring(input.lastIndexOf(' ') + 1, input.length()));
			statement = statement.replaceAll("\\bBLANK1\\b", word1(input));
			System.out.println(statement);
			
	    }
		
		}//
		
	}
	
	public static void main(String [] args) {
		
		brain();
		
	}
	
	

}
