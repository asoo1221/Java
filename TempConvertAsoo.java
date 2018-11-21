	import java.awt.Color;//Allow the use of custom colors via the instantiation of the Color class.
	import java.awt.event.ActionEvent;//I don't know how to comment this one.
	import java.awt.event.ActionListener;//Allow the use of action listeners on components which handle event triggers.

	import javax.swing.JButton; //Allow the use of buttons in the class
	import javax.swing.JFrame; //Allow the use of a new window
	import javax.swing.JOptionPane;//Allow the use of pre-made Java dialogs.
	import javax.swing.UIManager;//Allow the use of custom Look and Feels.
	import javax.swing.UnsupportedLookAndFeelException;//Handle errors which occur due to an invalid look and feel being set.

	//CTRL + SHIFT + O to fix imports

	public class TempConvertAsoo {
		public static String APP_NAME = "Converter";//Name of the Program 

		public static void main(final String[] args) {
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//try to change the look and feel to the systems one and catch any errors that occur 
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {  
				e.printStackTrace();
			}	

			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);//Displays frame in the center of the screen
			JButton btn = new JButton("Press to Enter Converter!");//press to enter the converter
			btn.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent event) { 

					JButton celButton = new JButton("Celsius");
					celButton.setBackground(Color.WHITE);
					celButton.setFocusPainted(false);//to remove Boxes around text 
					celButton.addActionListener(new ActionListener() { //add an actionlistener to display the Celsius to Fahrenheit conversion dialog 
						@Override
						public void actionPerformed(ActionEvent event) {
							toFahrenheit(); //Calls toFahrenheit method
						} 
					});
					JButton fahButton = new JButton("Fahrenheit");
					fahButton.setBackground(Color.WHITE);//background color
					fahButton.setFocusPainted(false);//to remove the boxes around text
					fahButton.addActionListener(new ActionListener() {//add an actionlistener to display the Fahrenheit to Celsius conversion dialog 
						@Override
						public void actionPerformed(ActionEvent event) {
							toCelsius();
						}
					});

					Object[] paneButtons = {celButton, fahButton}; // an Object array that stores the newly created buttons 

					int intro = JOptionPane.showOptionDialog(null, "Enter Celcius or Fahrenheit?", APP_NAME, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, paneButtons, paneButtons[0]);// creates a dialog that can give you a choice between celsius or fahrenheit 
						if(intro == JOptionPane.CLOSED_OPTION) {
							frame.dispose();
						}
				} 
			});   
			frame.add(btn); //Adds the button to the frame.
			frame.pack(); //Optimizes the frame so all components fit perfectly inside.
			frame.setVisible(true);//Show the frame after it has been initialized.
		}
		
		static void toFahrenheit() {//Display input field for Celsius Value and call this method whenever an error occurs within this method  
			String value = JOptionPane.showInputDialog(null, "Input a value in Celsius.");
			try {//try to convert the input celsius value to fahrenheit and catch any errors that occur 
				double inputVal = Double.parseDouble(value); // changes string to a double if its a valid value 
				double conversionOutput = (inputVal * (double)9/5) + 32;//use formula for conversion. This method is used to convert celsius to fahrenheit
				JOptionPane.showMessageDialog(null, "Input in Celsius: " + inputVal + '\u00B0' + "C" + "\nOutput in Fahrenheit: " + conversionOutput + '\u00B0' + "F", "Conversion Complete", JOptionPane.INFORMATION_MESSAGE); //Displays the conversion result 
				
			} catch(NumberFormatException ex) {//Catch an error which occurs whenever a non int value is inputted
				JOptionPane.showMessageDialog(null, "Incorrect value!", "Input Error", JOptionPane.ERROR_MESSAGE);
				toFahrenheit();
			} catch(NullPointerException nl) {
				//Leave this blank so it doesn't do anything
			}
		}
		
		static void toCelsius() {//Display input field for Celsius Value and call this method whenever an error occurs within this method  
			String value = JOptionPane.showInputDialog(null, "Input a value in Fahrenheit.");
			try {//try to convert the input fahrenheit value to celsius and catch any errors that occur 
				double inputVal = Double.parseDouble(value); // changes string to a double if its a valid value 
				double conversionOutput = (inputVal - 32) * (double)5/9; //use formula for conversion. This method is used to convert fahrenheit to celsius
				JOptionPane.showMessageDialog(null, "Input in Fahrenheit: " + inputVal + '\u00B0' + "F" + "\nOutput in Celsius: " + conversionOutput + '\u00B0' + "C", "Conversion Complete", JOptionPane.INFORMATION_MESSAGE); //Displays the conversion result 
				
			} catch(NumberFormatException ex) {//Catch an error which occurs whenever a non int value is inputted
				JOptionPane.showMessageDialog(null, "Incorrect value!", "Input Error", JOptionPane.ERROR_MESSAGE);
				toCelsius();
			} catch(NullPointerException nl) {
				//Leave this blank so it doesn't do anything
			}
		}
	}   