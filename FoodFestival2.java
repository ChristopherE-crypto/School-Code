package testing; //https://youtu.be/z6mQlr2jmuo
import java.util.Scanner;

public class FoodFestival2 {
	
	public static int displayMainMenu(String name) {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Select from the menu " + name + ":");
		System.out.println("0 - Nothing");
		System.out.println("1 - Appetizer");
		System.out.println("2 - Main Course");
		System.out.println("3 - Dessert");
		System.out.println("Enter the number for your selection:");
		
		int a = scnr.nextInt();
		
		return a;
	
	}
	
	public static int displayAppetizers() {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Appetizer Menu:");
		System.out.println("0 - Nothing");
		System.out.println("1 - Oysters");
		System.out.println("2 - Grilled Salmon");
		System.out.println("3 - Caesar Salad");
		System.out.println("Enter the number for your appetizer selection:");
		
		int a1 = scnr.nextInt();
		
		return a1;
		
	}
	
	public static int displayMainCourseMenu() {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Main Course Menu:");
		System.out.println("0 - Nothing");
		System.out.println("1 - Steak");
		System.out.println("2 - Chicken");
		System.out.println("3 - Roast Beef");
		System.out.println("Enter the number for your main selection:");
		
		int a2 = scnr.nextInt();
		
		return a2;
		
	}
	
	public static int displayDessert() {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Dessert Menu:");
		System.out.println("0 - Nothing");
		System.out.println("1 - Vanilla Ice Cream");
		System.out.println("2 - Rice Pudding");
		System.out.println("3 - Chocolate Cake");
		System.out.println("Enter the number for your appetizer selection:");
		
		int a3 = scnr.nextInt();
		
		return a3;
		
	}
	
	public static int displayToppings() {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Toppings Menu:");
		System.out.println("0 - Nothing");
		System.out.println("1 - Olive Oil");
		System.out.println("2 - Black Pepper Powder");
		System.out.println("3 - Olives");
		System.out.println("Enter the number for your topping selection:");
		
		int b = scnr.nextInt();
		
		return b;
		
	}
	
	public static int displayToppings2() {
		
        Scanner scnr = new Scanner(System.in);
		
		System.out.println("Toppings Menu:");
		System.out.println("0 - Nothing");
		System.out.println("1 - Olive Oil");
		System.out.println("2 - Black Pepper Powder");
		System.out.println("3 - Olives");
		System.out.println("Enter the number for your topping selection:");
		
		int b2 = scnr.nextInt();
		
		return b2;
	}
	
	public static int displayDessertTop() {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Toppings Menu:");
		System.out.println("0 - Nothing");
		System.out.println("1 - Powdered Sugar");
		System.out.println("2 - Syrup");
		System.out.println("3 - Nuts");
		System.out.println("Enter the number for your topping selection:");
		
		int c = scnr.nextInt();
		
		return c;
	}
	
	public static void main(String [] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String order = "";
		
		String oysters = "", grilled_Sal = "", caesar = "";
		
		String olive_Oil = "", blackPepper = "", olives = "";
		
		String olive_Oil2 = "", blackPepper2 = "", olives2 = "";
		
		String steak = "", chicken = "", roastB = "";
		
		String vanilla = "", rice_Pud = "", choc_Cake = "";
		
		String powSugar = "", syrup = "", nuts = "";
		
		System.out.println("Welcome to the food festival!");
		System.out.println("Would you like to place an order?"); //This part welcomes the user and asks if the person wants to place an order.
		String answer = scnr.next();
		
		while(!(answer.equalsIgnoreCase("Yes") || (answer.equalsIgnoreCase("No")))) {
			System.out.println("Would you like to place an order?");
			answer = scnr.next();
		}
		
		if(answer.equalsIgnoreCase("No")) { //If the user enters "No", print the message and end the program.
			System.out.println("Thanks for stopping by, maybe next time you'll sample our menu.");
			
		}
		if(answer.equalsIgnoreCase("Yes")) { //If the user enters "Yes", ask for the user's name and continue with the program.
			System.out.println("What is your name for the order?");
			String name = scnr.next();  //The user's name is stored in a variable.
			
			while(true) {
				
				int a = displayMainMenu(name);
				
				if(a == 0)
					break;
			
			
			switch(a) {
			
			case 1:
				
				while(true) { //Loop for appetizers.
					
				int a1 = displayAppetizers();
				
				if(a1 == 0)
					break;
				//Curly bracket used to be here for while loop.
				
				if(a1 == 1) {
					oysters = "Oysters";
				
				while(true) {
					
					int a2 = displayToppings();
					
					if(a2 == 0)
						break;
				//Same thing I said below this one.
				
				if(a2 == 1)
					olive_Oil = "Olive Oil";
				
				if(a2 == 2)
					blackPepper = "Black Pepper Powder";
				
				if(a2 == 3)
					olives = "Olives";
				
				}
			}
	
				else if(a1 == 2) {
					grilled_Sal = "Grilled Salmon";
					
					while(true) {
						
						int a2 = displayToppings();
						
						if(a2 == 0)
							break;
					//Curly bracket used to be here for loop for toppings.
					
					if(a2 == 1)
						olive_Oil = "Olive Oil";
					
					if(a2 == 2)
						blackPepper = "Black Pepper Powder";
					
					if(a2 == 3)
						olives = "Olives";
					
					}
				}
				
				else if(a1 == 3) {
					caesar = "Caesar Salad";
				
				while(true) {
					
					int a2 = displayToppings();
					
					if(a2 == 0)
						break;
				//Curly bracket used to be here for the loop for toppings.
				
				if(a2 == 1)
					olive_Oil = "Olive Oil";
				
				if(a2 == 2)
					blackPepper = "Black Pepper Powder";
				
				if(a2 == 3)
					olives = "Olives";
				
				}
				
			}
				}//End of the loop for appetizers.		
				break;
				
			case 2:
				
				while(true) {
					
					int b = displayMainCourseMenu();
					
					if(b == 0)
						break;
				//curly bracket used to be here for the while loop above.
				
				if(b == 1) {
					steak = "Steak";
					
					while(true) {
						
						int b1 = displayToppings2();
						
						if(b1 == 0)
							break;
					//Curly bracket used to be here.
					
					if(b1 == 1)
						olive_Oil2 = "Olive Oil";
					
					if(b1 == 2)
						blackPepper2 = "Black Pepper Powder";
					
					if(b1 == 3)
						olives2 = "Olives";
					}
				}
				
				if(b == 2) {
					chicken = "Chicken";
					
					while(true) {
						
						int b1 = displayToppings2();
						
						if(b1 == 0)
							break;
					//Curly bracket used to be here.
					
					if(b1 == 1)
						olive_Oil2 = "Olive Oil";
					
					if(b1 == 2)
						blackPepper2 = "Black Pepper Powder";
					
					if(b1 == 3)
						olives2 = "Olives";
					}
				}
				
				if(b == 3) {
					roastB = "Roast Beef";
					
					while(true) {
						
						int b1 = displayToppings2();
						
						if(b1 == 0)
							break;
					//Curly Bracket used to be here.
					
					if(b1 == 1)
						olive_Oil2 = "Olive Oil";
					
					if(b1 == 2)
						blackPepper2 = "Black Pepper Powder";
					
					if(b1 == 3)
						olives2 = "Olives";
					}
				}
				}
				break;
				
			case 3:
				
				while(true) {
					
					int c = displayDessert();
					
					if(c == 0)
						break;
				//Curly Bracket used to be here.
				
				if(c == 1) {
					vanilla = "Vanilla Ice Cream";
					
					while(true) {
						
						int c1 = displayDessertTop();
						
						if(c1 == 0)
							break;
					//Curly Bracket used to be here.
					
					if(c1 == 1)
						powSugar = "Powdered Sugar";
					
					if(c1 == 2)
						syrup = "Syrup";
					
					if(c1 == 3)
						nuts = "Nuts";
					}
				}
				
				if(c == 2) {
					rice_Pud = "Rice Pudding";
					
					while(true) {
						
						int c1 = displayDessertTop();
						
						if(c1 == 0)
							break;
					
					
					if(c1 == 1)
						powSugar = "Powdered Sugar";
					
					if(c1 == 2)
						syrup = "Syrup";
					
					if(c1 == 3)
						nuts = "Nuts";
					}
				}
				
				if(c == 3) {
					choc_Cake = "Chocolate Cake";
					
					while(true) {
						
						int c1 = displayDessertTop();
						
						if(c1 == 0)
							break;
					//curly bracket used to be here.
					
					if(c1 == 1)
						powSugar = "Powdered Sugar";
					
					if(c1 == 2)
						syrup = "Syrup";
					
					if(c1 == 3)
						nuts = "Nuts";
					}	
					}
				}
				break;
				
				}
			
			}
			
			if(olive_Oil.equals("Olive Oil") && blackPepper.equals("Black Pepper Powder")) {
				olive_Oil = "Olive Oil, ";
				blackPepper = "Black Pepper Powder";
			}
			if(olive_Oil.equals("Olive Oil") && olives.equals("Olives")) {
				olive_Oil = "Olive Oil";
				olives = ", Olives";
			}
			if(blackPepper.equals("Black Pepper Powder") && olives.equals("Olives")) {
				blackPepper = "Black Pepper Powder, ";
				olives = "Olives";
			}
			if(olive_Oil.equals("Olive Oil, ") && blackPepper.equals("Black Pepper Powder") && olives.equals("Olives")) {
				olives = ", Olives";
			}
			
			if(olive_Oil2.equals("Olive Oil") && blackPepper2.equals("Black Pepper Powder")) {
				olive_Oil2 = "Olive Oil, ";
				blackPepper2 = "Black Pepper Powder";
			}
			if(olive_Oil2.equals("Olive Oil") && olives2.equals("Olives")) {
				olive_Oil2 = "Olive Oil";
				olives2 = ", Olives";
			}
			if(blackPepper2.equals("Black Pepper Powder") && olives2.equals("Olives")) {
				blackPepper2 = "Black Pepper Powder, ";
				olives2 = "Olives";
			}
			if(olive_Oil2.equals("Olive Oil, ") && blackPepper2.equals("Black Pepper Powder") && olives2.equals("Olives")) {
				olives2 = ", Olives";
			}
			
			if(powSugar.equals("Powdered Sugar") && syrup.equals("Syrup")) {
				powSugar = "Powdered Sugar, ";
				syrup = "Syrup";
			}
			if(powSugar.equals("Powdered Sugar") && nuts.equals("Nuts")) {
				powSugar = "Powdered Sugar";
				nuts = ", Nuts";
			}
			if(syrup.equals("Syrup") && nuts.equals("Nuts")) {
				syrup = "Syrup, ";
				nuts = "Nuts";
			}
			if(powSugar.equals("Powdered Sugar, ") && syrup.equals("Syrup") && nuts.equals("Nuts")) {
				nuts = ", Nuts";
			}
			
			//This last part outputs the user's order. 
			System.out.println("Here's your order " + name + ":");
			order = "Appetizer: [" + oysters + grilled_Sal + caesar + ": " + olive_Oil + blackPepper + olives + "]\nMain Course: [" + steak + chicken + roastB + ": " + olive_Oil2 + blackPepper2 + olives2 + "]\nDessert: [" + vanilla + rice_Pud + choc_Cake + ": " + powSugar + syrup + nuts + "]\n";
			System.out.println(order);
			System.out.println("Enjoy your meal!");
			

				
			}
	}

}
