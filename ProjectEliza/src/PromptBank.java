import java.util.Random;

public class PromptBank {

	String [] questions;
	String [] statements;
	
	public PromptBank(){
		questions = new String[6]; //initialize your array to the correct length to match your number of questions you populate it with
		statements = new String[6];//initialize your array to the correct length to match your number of questions you populate it with
		
	}
	
	

	public void populateStatementsArray(){
		statements[0] = "Tell me more about BLANK1 and BLANK2";
		statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
		statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
		statements[3] = "Give me more detais about BLANK1 and BLANK2";
		statements[4] = "BLANK1 and BLANK2 are interesting, tell me more please";
		statements[5] = "Let's discuss BLANK1 and BLANK2";/*complete this method with your other statements using BLANK1 for word1
		 * and BLANK2 for word2 place holder 
		 */
	}
	public void populateQuestionsArray(){
		questions[0] = "Is there anything else about BLANK1 and BLANK2?";
		questions[1] = "Does BLANK1 bother you? How about BLANK2?";
		questions[2] = "Are BLANK1 and BLANK2 things you think about often?";
		questions[3] = "Are BLANK1 and BLANK2 connected?";
		questions[4] = "How does BLANK2 make you feel? What about BLANK1?";
		questions[5] = "Do you care about BLANK1 and BLANK2?";
		/*complete this method with your other questions using BLANK1 for word1
		 * and BLANK2 for word2 place holder 
		 */
		
	}
	  
	public String getRandomStatementTrunk(){
		Random num = new Random();//fill in the method so it randomly selects the statement template
		int selection = num.nextInt(6);
		
		switch(selection) {
		case 0:
			return statements[0];
		case 1:
			return statements[1];
		case 2:
			return statements[2];
		case 3:
			return statements[3];
		case 4:
			return statements[4];
		case 5:
			return statements[5];
		default:
			return "I could not understand what you said.";
			
		}
		//from the questions array ... hint use Math.random() to get the random index
		//so you can replace BLANK1 and BLANK2 with the appropriate words
	}
	
	
	public String getRandomQuestionTrunk(){
		Random num = new Random();
		int selection = num.nextInt(6);
	
		switch(selection) {
		case 0:
			return questions[0];
		case 1:
			return questions[1];
		case 2:
			return questions[2];
		case 3:
			return questions[3];
		case 4:
			return questions[4];
		case 5:
			return questions[5];
		default:
			return "I could not understand what you said.";
		//fill in the method so it randomly selects the question template
		//from the questions array ... hint use Math.random() to get the random index
		//so you can replace BLANK1 and BLANK2 with the appropriate words
	}
	
	
	}	
}
