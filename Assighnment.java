package Assignment;

import java.util.Scanner;

public class Assighnment {//Start Class.
    //____________________________________________Global Declarations___________________________________________________
    private static String user_name[] = {"Matt", "Mark", "John"};//Array of users.
    private static int user_PIN[] = {1336, 1337, 1338};//Array for user PINs.
    private static double user_money[] = {10, 100, 1000};//Array for user's balance.
    private static boolean user_overdraft[] = {false, true, true};//Array for user overdraft..

    private static int menu_choice;//Returns to Main Method.
    private static int id;//Value to Index User Info.
    private static boolean access;//Grants access to Main Menu.

    //_______________________________________________Methods________________________________________________________

    // 0. Main Method
    public static void main(String args[]) {//Start main.
        display_customers();
        id = login();

        while (access) {//Start while loop.
            main_menu();

            switch (menu_choice) {//Start switch.

                case 1:
                    view_bankStatement();
                    break;
                case 2:
                    deposit_money();
                    break;
                case 3:
                    withdraw_money();
                    break;
                case 4:
                    change_password();
                    break;
                case 5:
                    id = login();
                    break;
                case 6:
                    exit();
                    break;

            }//End switch.
        }//End while loop.
    } // End Main.

    //1. Display All Customers
    public static void display_customers() {
        System.out.println("  All Customers");
        System.out.println("Index\tName\tBalance\tPIN");
        for (int i = 0; i < user_money.length; i++) {
            System.out.println(i + "\t" + user_name[i] + "\t" + user_money[i] + "\t" + user_PIN[i]);
        }//End for loop.
    }//End Method.

    // 2. Login
    private static int login() {//Start method.

        //Method Declarations
        String name;//Used to store username input to compare with array usernames.
        int PIN;//Used to store PIN input to compare with array PINs.
        int attempts;//Used to track if a user has used up all attempts.
        int choice;//Used to store user choice input for switch.
        boolean loop;//Used to control a while loop.

        String attemptsString[] = {"no attempts", "one attempt", "two attempts"};

        //Starting Printout
        System.out.println("____________________________________________________________________________");
        System.out.println("                               Welcome                             ");
        System.out.println("____________________________________________________________________________");

        //For Loop for Attempts
        for (attempts = 3; attempts > 0; attempts--) {//Start for loop.

            //Inputs
            System.out.println("Enter username: ");
            name = textInput();
            System.out.println("Enter PIN: ");
            PIN = intInput();

            //For Loop
            for (int i = 0; i < user_name.length; i++) {//Start for loop.

                if (name.equals(user_name[i]) && PIN == user_PIN[i]) {//Start if statement.
                    access = true;
                    System.out.println("Successful login.");
                    return id = i;
                }//End if statement.
            }//End for loop.

            //If 0 Attempts Remain
            if ((attempts - 1) == 0) {//Start if statement.
                System.out.println("Login failed, you have no attempts remaining. ");
                access = false;
                return -1;
            }//End if statement.

            //Retry Printout
            System.out.println("Incorrect login, would you like to retry?");
            System.out.println("1. Retry.");
            System.out.println("2. Exit.");
            System.out.print("Enter a number associated with an option: ");

            //Choice Input Loop
            loop = true;
            while (loop) {//Start while loop.
                choice = intInput();

                //Switch Based on Retry Choice
                switch (choice) {//Start switch.
                    case 1: // if choice = 1
                        System.out.println("____________________________________________________________________________");
                        System.out.println("Retrying, you have " + attemptsString[(attempts - 1)] + " remaining.\n");
                        loop = false;
                        access = false;
                        break;
                    case 2: // if choice = 2
                        System.out.println("Goodbye.");
                        access = false;
                        return -1;
                    default:
                        System.out.println("Error, not an option.");
                        break;

                }//End switch.
            }//End while loop.
        }//End for loop.
        return -1;
    }//End Method.

    // 3. Main Menu
    private static void main_menu() {//Start Method.
        //Method Declarations
        boolean loop = true;

        //Starting Printout
        System.out.println("____________________________________________________________________________");
        System.out.println("Welcome " + user_name[id] + ",");
        System.out.println("What you like to do? Type a number associated with one of the following:");
        System.out.println("");
        System.out.println("1. View bank statement.");
        System.out.println("2. Deposit money.");
        System.out.println("3. Withdraw money.");
        System.out.println("4. Change password.");
        System.out.println("5. Return to login screen.");
        System.out.println("6. Exit.");
        System.out.println("");

        //Input
        while (loop) {//Start while loop.
            menu_choice = intInput();

            if (menu_choice <= 6 && menu_choice >= 1) {//Start if statement.
                loop = false;
            }//End if statement.
            else {//Start else.
                System.out.println("Error option not found, try again.");
            }//End else.

        }//Emd while loop.
    }//End Method.

    // 4. Change Password
    private static void change_password() {//Start Method.
        //Method Declarations
        int newPIN;
        int choice;
        boolean loop = true;
        boolean inputNewPIN = false;

        //Starting Printout
        System.out.println("____________________________________________________________________________");
        System.out.println("Your current PIN is: " + user_PIN[id]);
        System.out.println("");
        System.out.println("1. Change.");
        System.out.println("2. Return to menu.");
        System.out.print("Enter number: ");

        //Choice Input
        while (loop) {//Start while loop.
            choice = intInput();

            //Choice Switch
            switch (choice) {//Start switch.

                case 1:
                    loop = false;
                    inputNewPIN = true;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Returning to menu.");
                    return;
                default:
                    System.out.println("");
                    System.out.println("Error, must pick an option between 1-2");
                    System.out.print("Enter number: ");
                    break;
            }//End switch.
        }//End while loop.

        //Change Password
        if (inputNewPIN) {//Start if statement.
            System.out.println("");
            System.out.println("Enter new PIN: ");
            newPIN = intInput();
            System.out.println("");

            //Check for Existing PIN
            for (int i = 0; i < user_PIN.length; i++) {//Start for loop.
                if (newPIN == user_PIN[i]) {//Start if statement.
                    System.out.println("Error, PIN must be unique.");
                    return;
                }//End if statement.
            }//End for loop.

            //Password Change Confirmation Printout
            System.out.println("Your new PIN will be: " + newPIN);
            System.out.println("1. Accept.");
            System.out.println("2. Decline.");
            System.out.print("Enter number: ");

            //Password Change Confirmation Input
            loop = true;
            while (loop) {//Start while loop.
                choice = intInput();

                //Confirmation Choice Switch
                switch (choice) {//Start switch.

                    case 1:
                        user_PIN[id] = newPIN;
                        System.out.println("");
                        System.out.println("PIN is changed.");
                        loop = false;
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("PIN is not changed.");
                        loop = false;
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Error, must pick an option between 1-2");
                        System.out.print("Enter number: ");
                        break;
                } //End switch.
            } //End while loop.
        } //End if statement.
    }//End Method.

    // 5. Bank Statement
    private static void view_bankStatement() {//Start Method.
        System.out.println("Your name is " + user_name[id]);
        System.out.printf("Your current balance is €%.2f \n", user_money[id]);
        if (user_overdraft[id]) {//Start if statement.
            System.out.println("You have an Overdraft.");
        }//End if statement.
        else {//Start else.
            System.out.println("You do not have an Overdraft.");
        }//End else.
        System.out.println("\n Press enter to continue.");
        textInput();
        System.out.println(" Returning to main menu.");
    }//End Method.

    // 6. Exit
    private static void exit() {//Start Method.
        System.out.println("Thank you for using the ATM.");
        access = false;
    }//End Method.

    // 7. Deposit Money Interface
    private static void deposit_money() {//Start Method.
        double amount;
        System.out.println("Please input the amount you want to deposit into your account: ");
        amount = currencyInput();
        user_money[id] = user_money[id] + amount;
        System.out.printf("You have deposited €%.2f into your account\n", amount);
        System.out.printf("Your balance is now  €%.2f\n", user_money[id]);
    }//End Method.

    // 8. Withdraw Money Interface
    private static void withdraw_money() {//Start Method.
        double amount;
        System.out.println("Please input the amount you want to withdraw from your account: ");
        amount = currencyInput();
        user_money[id] = user_money[id] - amount;
        System.out.printf("You have chosen to withdraw €%.2f from your account\n", amount);

        //In event of withdrawing over balance.
        if (user_overdraft[id]) {//Start if statement.
            System.out.println("You are utilising your overdraft.");
        }//End if statement.
        else if (user_money[id] < 0) {//Start else if.
            System.out.println("You have insufficient funds to withdraw this amount");
            user_money[id] = user_money[id] + amount;
        }//End else if.
        System.out.printf("Your balance is now €%.2f\n", user_money[id]);
    }//End Method.

    //____________________________________________Input Methods____________________________________________________

    // 9. Text Input
    private static String textInput() {//Start Method.

        //Declarations and Initializations
        Scanner sc = new Scanner(System.in);

        //Return
        return sc.nextLine();
    }//End Method.

    // 10. Integer Input
    private static int intInput() {//Start Method.

        //Declarations and Initializations
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        //While Loop
        while (!input.matches("\\d+")) {//Start while loop.

            //Error Printout
            System.out.println("Error,input must be a number.");
            input = sc.nextLine();
        }   //End while loop.
        //Return
        return Integer.parseInt(input);
    }//End Method.

    // 11. Currency Input
    private static double currencyInput() {

        //Declarations and Initializations
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        //While Loop
        while (!input.matches("\\d+(\\.\\d\\d)?|(\\d+)?\\.\\d(\\d)?")) {//Start while loop.

            //Error Printout
            System.out.println("Error, input must be a number, up to two decimal digits allowed.");
            System.out.println("Example, '100.00' or '100'. ");
            input = sc.nextLine();// Take user input again.

        }//End while loop.
        //Method Return
        return Double.parseDouble(input);
    }//End Method.


}//End Class.
