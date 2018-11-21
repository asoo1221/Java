import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class test {

	public static void main(final String[] args) {

		Scanner input = new Scanner(System.in);
		
		final JFrame parent = new JFrame();
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton();
		button.setText("Click!");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String name = JOptionPane.showInputDialog(null, "Enter Celcius and Fahrenheit?", "Title", JOptionPane.PLAIN_MESSAGE);
				
			} 
		});
		parent.add(button);
		parent.pack();
		parent.setVisible(true);

		float temperatue;
		Scanner in = new Scanner(System.in);      
		String tempscale= "";

		System.out.println("Enter temperatue in Fahrenheit");
		temperatue = in.nextInt();

		temperatue = (temperatue - 32.0f) * 5/9; // This is the formula for the main conversion , for example T(°C) = (68°F - 32) × 5/9 = 20 °C 
		// (Example and formula taken from http://www.rapidtables.com/convert/temperature/how-fahrenheit-to-celsius.htm)


		System.out.println("Temperatue in Fahrenheit = " + temperatue);// plus temp is to minus from the formula as seen from the above section

		int selection = input.nextInt();
		if (selection == 1) {
			System.out.println("Enter a degree in Celcius:");// To get ready for a conversion
			//far2cel();
		} else if (selection == 2) {
			System.out.println("Enter a degree in Celsius:");// This will be the question when entering the given numbers
			//cel2far();
		} else {
			System.out.println("Bye.."); // This is also the ending message
		}
	}        
}  