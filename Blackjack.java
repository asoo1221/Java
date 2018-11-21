package Assignment;

import java.util.ArrayList; //An array to which you can append objects to
import java.util.HashMap; //A map used to store a data type which can be retrieved by passing another data type
import java.util.Map; 
import java.util.Random; //A class used to generate a random number
import java.util.Scanner; //A class used for user input via the console


public class Blackjack { //New public class called Blackjack
	String[] cardSuits = {"Diamonds", "Clubs", "Spades", "Hearts"};//create a new String array which stores the card suits	
	ArrayList<String> cardNames = new ArrayList<String>(); //create an ArrayList to store the names of all cards in the deck
	Map<String, Integer> deck = new HashMap<String, Integer>(); //create a new Map to assign a value to each card name
	boolean hitting = false; //new boolean variable used to determine whether the player is hitting
	boolean passed = false; //new boolean variable used to determine whether the player has passed
	int sum = 0; //new integer variable used to store the card total of the player
	int sumDealer = 0; //new integer variable used to store the card total of the dealer
	String firstDealerCard; //new String variable used to store the name of the first card the dealer has drawn
	String hiddenCard; //new String variable used to store the name of the second card (hidden card) that the dealer has drawn
	int firstDealerCardValue = 0; //New integer variable used to store the value of the first card the dealer has drawn
	int hiddenCardValue = 0; //New integer variable used to store the value of the second card (hidden card) that the dealer has drawn 

	public static void main(String[] args) {//Main method. Every Java program starts in here.
		new Blackjack().createCards(); //Create a new instance of the Blackjack class and call the createCards() method
	}

	private void createCards() { //method used to create the deck of cards
		for(int suit = 0; suit < cardSuits.length; suit++) { //keep looping until the integer suit is no longer smaller than the length of the cardSuits array
			for(int card = 0; card < 13; card++) { //nested loop which loops 13 times
				cardNames.add(changeName((card + 1)) + " of " + cardSuits[suit]); //create a new card name by using the changeName() method and by getting the card suit, and add it to the cardNames() array
				deck.put(changeName((card + 1)) + " of " + cardSuits[suit], changeValue(card + 1)); //add the newly created card to the deck Map and assign a value to that card by using the changeValue() method
			}
		}
		startGame(); //Initialize the game
	}

	private void startGame() { //used to initialize the game
		Scanner sc = new Scanner(System.in); //create a new instance of the Scanner class which will be used to accept user input
		Random r = new Random(); //create a new instance of the Random class which will be used to randomize the cards drawn
		String answer; //create a new String variable which will be used to store the answer received by the user
		String playerSumString = "";  //create a new String variable which will be used to store the full sum of the player (e.g. 2 + 5 + 6)
		System.out.println("Hi! Would you like to play some Blackjack?"); //print a welcome message to the console.
		answer = sc.nextLine(); //pause until user input is received
		if(answer.toLowerCase().contains("ye")) { //test if the user input contains the 'ye' keyword
			System.out.println("Great! Let's start.");
			int card1 = r.nextInt(cardNames.size()); //get a random number between 0 and the size of the cardNames array - 1 to get a random card from the deck and then store it in the card1 integer variable
			int card2 = r.nextInt(cardNames.size()); //get a random number between 0 and the size of the cardNames array - 1 to get a random card from the deck and then store it in the card2 integer variable
			sum = deck.get(cardNames.get(card1)) + deck.get(cardNames.get(card2)); //set the sum of the player equal to the sum of the two random cards. The card values are returned after passing the name of the card into the Map's get() method 
			System.out.println("You draw: " + cardNames.get(card1) + " and " + cardNames.get(card2)); //display what cards have been drawn by the user
			playerSumString += deck.get(cardNames.get(card1)) + " + " + deck.get(cardNames.get(card2)); //add the two values to the sum String
			System.out.println(playerSumString + " = " + sum); //Display the sum and the total
			deck.remove(cardNames.get(card1)); //remove card1 from the deck
			deck.remove(cardNames.get(card2)); //remove card2 from the deck
			cardNames.remove(cardNames.get(card1)); //remove card1 from the cardNames array
			if(card2 != 0) { //test if card2 is not equal to 0
				cardNames.remove(cardNames.get(card2 - 1)); //remove the index before the random index. This is done because when a card is removed, the size of the ArrayList decreases.
			} else {
				cardNames.remove(cardNames.get(card2)); //remove the normal index
			}
			
			//The same thing is done with the dealer
			int card1Dealer = r.nextInt(cardNames.size());
			int card2Dealer = r.nextInt(cardNames.size());
			firstDealerCard = cardNames.get(card1Dealer); //assigns the first card the dealer has drawn to the firstDealerCard String variable for use later
			firstDealerCardValue = deck.get(cardNames.get(card1Dealer)); //Assigns the value of the first card the dealer has drawn to the firstDealerCardValue integer variable for use later
			hiddenCard = cardNames.get(card2Dealer); //assign the second card the dealer has drawn to the hiddenCard String variable for use later
			hiddenCardValue = deck.get(cardNames.get(card2Dealer)); //assigns the value of the first card the dealer has drawn to the hiddenCardValue integer variable for use later
			sumDealer = firstDealerCardValue + hiddenCardValue; //set the total of the dealer to the sum of the two cards
			System.out.println("Dealer draws: " + cardNames.get(card1Dealer) + " and " + "?"); //display which cards have been drawn by the dealer but hide the second card
			System.out.println("Dealer's Total: " + deck.get(cardNames.get(card1Dealer)) + " + ?" + " = ?"); //display the sum of the dealer's cards but don't display the second card or the total
			deck.remove(cardNames.get(card1Dealer));
			deck.remove(cardNames.get(card2Dealer));
			cardNames.remove(cardNames.get(card1Dealer));
			if(card2Dealer != 0) {
				cardNames.remove(cardNames.get(card2Dealer - 1));
			} else {
				cardNames.remove(cardNames.get(card2Dealer));
			}
			System.out.println("Hit or Pass?"); //ask the user whether to hit or pass
			answer = sc.nextLine(); //waits for user input and assign it to the answer String variable
			if(answer.toLowerCase().contains("hit")) { //Tests if the answer of the user is 'hit'
				hitting = true; //set the hitting boolean variable to true
			} else { //pass if the user replies with anything other than 'hit'
				hitting = false; //set the hitting boolean variable to false
				passed = true; //set the passed boolean variable to true
			}
			while(hitting && sum < 21) { //keep looping while hitting is true and the total sum of the player is smaller than 21
				int newCard = r.nextInt(cardNames.size()); //randomize a new card index
				sum += deck.get(cardNames.get(newCard)); //get the value of the new card and add it to the total sum of the user
				System.out.println("You draw: " + cardNames.get(newCard)); //display what card has been drawn by the user
				playerSumString += " + " + deck.get(cardNames.get(newCard)); //add the card's value to the sum string
				deck.remove(cardNames.get(newCard)); //remove the card from the deck
				cardNames.remove(cardNames.get(newCard)); //remove the card from the cardNames ArrayList
				System.out.println("Player's Total: " + playerSumString + " = " + sum); //display the full sum and total of the user
				if(sum < 21) { //test if the sum of the user is smaller than 21
					System.out.println("Hit or Pass?"); //ask whether the user wants to hit or pass
					answer = sc.nextLine();
					if(answer.toLowerCase().contains("hit")) {
						hitting = true;
					} else {
						passed = true;
						hitting = false;
					}
				} 
			}
			//break out of the loop if the user has either passed or got a sum higher than 20
			if(passed) { //test if the user has passed
				if(sum > sumDealer && sumDealer < 18) { //test if the sum of the user is greater than the sum of the dealer and check if the sum of the dealer is lower than 18
					int newDealerCard = r.nextInt(deck.size()); //randomize a new card index
					sumDealer += deck.get(cardNames.get(newDealerCard)); //get the value of the new card and add it to the total sum of the dealer
					System.out.println("Dealer draws: " + cardNames.get(newDealerCard)); //display which card was drawn by the dealer
					System.out.println("Hidden card: " + hiddenCard); //display the card which was hidden at the start
					System.out.println("Dealer's Total: " + firstDealerCardValue + " + " + hiddenCardValue + " + " + deck.get(cardNames.get(newDealerCard)) + " = "  + sumDealer); //display the full sum and total of the dealer
					deck.remove(cardNames.get(newDealerCard)); //remove the card from the deck
					cardNames.remove(cardNames.get(newDealerCard)); //remove the card from the cardNames ArrayList
				} else { //test if the dealer's sum is higher than the user's or if the dealer's sum is higher than 17
					System.out.println("The dealer doesn't draw any additional cards."); //notify the player that the dealer has not drawn any additional cards
				}
			}
			
			if(sum == sumDealer) { //Check if the sum of the player is equal to the sum of the dealer
				System.out.println("Draw! Dealer wins!"); //Display a losing message and the reason for the loss.
				System.out.println("Your total: " + sum); //Display the total sum of the user
				System.out.println("Dealer total: " + sumDealer); //Display the total sum of the dealer
			} else if(sum > sumDealer && sum < 21) { //Check if the sum of the user is greater than the sum of the dealer and check if the sum of the user is smaller than 21
				System.out.println("You win! Your total was higher than the dealer's. Congratulations."); //Display a winning message and the reason for the win.
				System.out.println("Your total: " + sum);
				System.out.println("Dealer total: " + sumDealer);
			} else if(sum == 21) { //Check if the sum of the user is equal to 21
				System.out.println("You win! You got 21. Congratulations.");
				System.out.println("Your total: " + sum);
				System.out.println("Dealer total: " + sumDealer);
			} else if(sumDealer == 21) { //Check if the sum of the dealer is equal to 21
				System.out.println("Dealer wins! The dealer got 21.");
				System.out.println("Your total: " + sum);
				System.out.println("Dealer total: " + sumDealer);
			} else if(sum > 21) { //Check if the sum of the user is greater than 21
				System.out.println("Dealer wins! You went over 21.");
				System.out.println("Your total: " + sum);
				System.out.println("Dealer total: " + sumDealer);
			} else if(sumDealer > 21) { //Check if the sum of the dealer is greater than 21
				System.out.println("You win! The dealer went over 21. Congratulations.");
				System.out.println("Your total: " + sum);
				System.out.println("Dealer total: " + sumDealer);
			} else { //This else statement executes if the dealer's total was higher than the user's at the end of the game
				System.out.println("Dealer wins! The dealer's total was higher than yours.");
				System.out.println("Your total: " + sum);
				System.out.println("Dealer total: " + sumDealer);
			}
			
			System.out.println("Would you like to play again?");
			answer = sc.nextLine();
			if(answer.toLowerCase().contains("ye")) {
				new Blackjack().createCards(); //Create a new instance of the Blackjack class again and setup a new deck
			} else {
				System.out.println("Okay! Thank you for playing."); //Thank the user for playing
				System.exit(0); //Close the application
			}
		} else { //Exit if the user replies with something other than a 'yes'
			System.out.println("Okay! Exiting..."); //Notify the player than the application is closing.
			System.exit(0); //Close the application
		}
		sc.close();//Close the Scanner to avoid any resource leaks
	}

	private int changeValue(int i) { //Method used to change the value of the cards to match the requirement of 2 - 11 from the brief. This method takes in one integer as its only parameter
		if(i == 1) { //Check if the passed integer is equal to 1
			return 11; //1 is an Ace so this returns 11
		} else if(i >= 10) { //Check if the passed integer is greater than or equal to 10
			return 10; //11 and up include King, Queen and Jack. All of these return 10
		} else { //Executes if the passed integer doesn't trigger any previous if statements
			return i; //Returns the original integer
		}
	}
	
	//1 = Ace | King = 11 | Queen = 12 | Jack = 13
	private String changeName(int i) { //Method used to change the card number originally assigned to the card by the loop into a recognisable String. This method takes in one integer as its only parameter
		if(i == 1) { //Check if the integer i is equal to 1
			return "Ace"; //Return the name of the card
		} else if(i == 11) { //Check if the integer i is equal to 11
			return "King"; //Return the name of the card
		} else if(i == 12) { //Check if the integer i is equal to 12
			return "Queen"; //Return the name of the card
		} else if(i == 13) { //Check if the integer i is equal to 13
			return "Jack"; //Return the name of the card
		} else { //Check if the integer i doesn't trigger any of the previous if statements
			return i + ""; //Return the original integer as a String
		}
	}

}