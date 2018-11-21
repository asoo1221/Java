package Assignment;


	import java.awt.Color;//Allow the use of custom colors via the instantiation of the Color class.
import java.awt.event.ActionEvent;//I don't know how to comment this one.
import java.awt.event.ActionListener;//Allow the use of action listeners on components which handle event triggers.

import javax.swing.JButton; //Allow the use of buttons in the class
import javax.swing.JFrame; //Allow the use of a new window
import javax.swing.JOptionPane;//Allow the use of pre-made Java dialogs.
import javax.swing.UIManager;//Allow the use of custom Look and Feels.
import javax.swing.UnsupportedLookAndFeelException;//Handle errors which occur due to an invalid look and feel being set.

	//CTRL + SHIFT + O to fix imports

	public class Test3 {
		public static String APP_NAME = "EightBall";//Name of the Program 

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
			JButton btn = new JButton("Press to Enter the Eight ball!");//press to enter the converter
			btn.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent event) { 

			
					JButton Button = new JButton("EightBall");
					Button.setBackground(Color.WHITE);//background color
					Button.setFocusPainted(false);//to remove the boxes around text
					Button.addActionListener(new ActionListener() {//add an actionlistener 
						@Override
						public void actionPerformed(ActionEvent event) {
							
						}
					});

					Object[] paneButtons = {Button}; // an Object array that stores the newly created buttons 

					int intro = JOptionPane.showOptionDialog(null, "Click to Enter!", APP_NAME, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, paneButtons, paneButtons[0]);// creates a dialog that can give you a choice between celsius or fahrenheit 
						if(intro == JOptionPane.CLOSED_OPTION) {
							frame.dispose();
						}
				} 
			});   
			frame.add(btn); //Adds the button to the frame.
			frame.pack(); //Optimizes the frame so all components fit perfectly inside.
			frame.setVisible(true);//Show the frame after it has been initialized.
		}
		


}
