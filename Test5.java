package Assignment;


import java.awt.Color;//Allow the use of custom colors via the instantiation of the Color class.


import java.awt.event.ActionEvent;//An object that represents the event,eg a Button
import java.awt.event.ActionListener;//Allow the use of action listeners on components which handle event triggers.
import java.util.Random;//to make a random response

import javax.swing.JButton; //Allow the use of buttons in the class
import javax.swing.JFrame; //Allow the use of a new window
import javax.swing.JOptionPane;//Allow the use of pre-made Java dialogs.
import javax.swing.UIManager;//Allow the use of custom Look and Feels.
import javax.swing.UnsupportedLookAndFeelException;//Handle errors which occur due to an invalid look and feel being set.



public class Test5 {
	public static String APP_NAME = "EightBall";//Name of the Program 

	public static void main(final String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//try to change the look and feel to the systems one and catch any errors that occur 
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException//
				| UnsupportedLookAndFeelException e) {  
			e.printStackTrace();
		}	
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits the application completely when the dialog is closed.
		frame.setLocationRelativeTo(null);//Displays frame in the center of the screen
		JButton btn = new JButton("Press to Enter the Eight ball!");//press to enter the eight ball
		btn.addActionListener(new ActionListener(){ // An Actionlistner is a class that implements an interface that contains the Actionpreformed method. 
			public void actionPerformed(ActionEvent event) { 


				JButton Button = new JButton("EightBall");//name of the button
				Button.setBackground(Color.RED);//background color
				Button.setFocusPainted(false);//to remove the boxes around text
				Button.addActionListener(new ActionListener() {//adds an actionlistener to allow the button to be interactive.
					@Override
					public void actionPerformed(ActionEvent event) {//An Actionlistner is a class that implements a an interface that contains the Actionpreformed method. 
						String value = JOptionPane.showInputDialog(null, "Input A Question");//putting in a question
						if(value != null && !value.isEmpty() && !isInt(value)) { // if the value is not null and the value is not empty and isnt an intiger , it randomize and displays an ansewer
							String[] Answer = {"it is certain", "it is decidedly so", "without a doubt", "Yes definitely", "You may rely on it", "Yep", "Signs point to yes", "My reply is no", "My Sources say no", "Outlook not so good", "Very doubtful", "Concentrate and ask again", "Cannot predict now", "Better not tell you now", "As i see it, yes", "Most likely", "it is certain", "Don't count on it", "Reply hazy try again", "Ask again later"};//string Array to hold all possible responses
							Random r = new Random();//create a random response
							JOptionPane.showMessageDialog(null, "My Answer is: " + Answer[r.nextInt(Answer.length)]);//Opens a dialog displaying the randomly generated answer using the array , random class
						}else if(value == null || value.isEmpty()){//This If statement runs if nothing was input into the field 
							JOptionPane.getRootFrame().dispose();//disposes of the randomly generated 
						}else if(value != null && !value.isEmpty() && isInt(value) ) {//if value is not empty and is an intiger.
							JOptionPane.showMessageDialog(null, "Incorrect value!", "Input Error", JOptionPane.ERROR_MESSAGE);//error when a user inputs a log 
							
						}

					}
				});

				Object[] paneButtons = {Button}; // an Object array that stores the newly created buttons 

				int intro = JOptionPane.showOptionDialog(null, "Click to Enter!", APP_NAME, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, paneButtons, paneButtons[0]);// creates a dialog box that can allow you to enter the application.
				if(intro == JOptionPane.CLOSED_OPTION) {
					frame.dispose();//closes the program completely 

				}

			} 
		}); 
		frame.add(btn); //Adds the button to the frame.
		frame.pack(); //Optimizes the frame so all components fit perfectly inside.
		frame.setVisible(true);//Show the frame after it has been initialized.


	}	
	private static boolean isInt (String s) {//Its a function that determines weather a string is a integer.
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};//Array to store all numbers.
		for(int i : numbers){//iterate through number array
			if(s.contains(i+"")){//check if the passed string contains a number and if it does return true.
				return true; 
			} 
		} 
		return false;
	}

}