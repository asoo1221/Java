package Assignment;

import java.util.Scanner; //A class used for user input via the console


public class Riddle{

	public static void main( String[] args) {
		Scanner sc = new Scanner(System.in);
		String step1;
		String step2;
		String answer1;
		String answer2;
		
		System.out.println("Welcome to the Puzzle Choose input the number 1 to begin");
		
		step1 = sc.nextLine();
		System.out.println("You can Carry it everywhere you go, and it does not get heavy. What is it?");
		answer1 = sc.nextLine();
		System.out.println("Your name");
		System.out.println("Riddle 1 completed");
		System.out.print("Continue by pressing by inputting the number 2");
		
		step2 = sc.nextLine();
		System.out.println("I have keys but no locks. I have a space but no room. You can enter, but can’t go outside. What am I?");
		answer2 = sc.next();
		System.out.println("A keybaord");
		System.out.println("Riddle 2 complete");
		
		if(answer1 != step1);
		System.out.println("Error");
		
	    if(answer1 == step2);
		System.out.println("Proceed to next stage");
		
		if(answer2 != step1);
		System.out.println("Error");
		
	    if(answer1 == step1);
		System.out.println("Proceed to next stage");
		
		
		
		
		
		
		
		
	}
	
}

		
		
	