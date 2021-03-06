package Lists;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertionSort {


	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	public static JPanel display = new JPanel();
	public static JButton button = new JButton();
	public static JTextField text = new JTextField(20);

	public InsertionSort() {
		UI(); //call basic UI setup
		Button(); //add button and functionality
	}
	
	/**
	 * This is used for the initial UI setup
	 */
	public void UI() {

		frame.setTitle("Insertion Sort");
		frame.setSize(1200,1200);
		frame.setVisible(true);
		frame.getContentPane();

		Label menu = new Label("Enter a list using CSV format");
		text.setSize(100, 100);

		panel.add(menu);
		panel.add(text);
		panel.setSize(50, 50);
		
		frame.add(panel);
	}
	
	/**
	 * Set up for the button and response when pressed
	 */
	public void Button() {
		button = new JButton();
		button.setText("Sort List!");
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = text.getText();
				int[] arrayInput = stringToArray(input);
				insertionSort(arrayInput);
			}
		};
		
		button.addActionListener(listener);
		panel.add(button);

	}



	public static void main(String[] args) {

		new InsertionSort();
		
	}

	/**
	 * This method takes a string and parse it as an array containing int numbers 
	 * @param input
	 * @return
	 */
	public static int[] stringToArray(String input) {
		
		String[] strArray = input.split(",");
		int[] intArray = new int[strArray.length];

		for(int i = 0; i<strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}

		return intArray;

	}
	
	/**
	 * Insertion Sort for array of int
	 * @param array
	 */
	public static void insertionSort(int [] array) {
		int length = array.length;
		int iteration = 0;

		for(int i = 1; i < length; i ++) {

			int key = array[i];
			int hole = i;
			while(hole > 0 && array[hole-1] > key) {
				array[hole] = array[hole-1];
				hole--;
			}
			array[hole] = key;
			iteration++;
			toLabel(array,iteration);
		}
	}

	/**
	 * Method to format array to properly display on the frame
	 * @param array
	 * @return
	 */
	public static String toLabel(int [] array, int iteration) {
		String s = "";

		for(int i = 0; i< array.length; i++) {
			s = s + array[i] + "|";
		}

		s = "Iteration" + iteration + ": " + s;

		Label label = new Label(s);
		Dimension size = label.getPreferredSize();
		label.setBounds(150, 100, size.width, size.height);
		label.setFont(new Font("Serif", Font.PLAIN, 34));
		panel.add(label);	
		s = ""; //trim the string for next iteration

		return s;

	}
}
