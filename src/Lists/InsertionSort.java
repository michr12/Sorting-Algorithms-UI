package Lists;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertionSort {


	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	public static JPanel display = new JPanel();
	public static JButton button = new JButton();
	public static JTextField text = new JTextField(20);
	public static String list;
	
	public InsertionSort() {
		UI(); //call basic UI setup
		Button(); //add button and functionality
	}
	
	public void UI() {

		frame.setTitle("Insertion Sort");
		frame.setSize(1200,1200);
		frame.setVisible(true);
		frame.getContentPane();

		Label menu = new Label("Iterations by using Insertion Sort method");
		text.setSize(100, 100);
		
				
		System.out.println(list);
		panel.add(text);
		panel.add(menu);
		
		panel.setSize(50, 50);
		frame.add(panel);
	}
	
	public void Button() {
		button = new JButton();
		button.setText("Enter");
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
		
		//new InsertionSort();
		String test = "12,5,3,7";
		int[] array = stringToArray(test);
		
		for(int i =0 ; i< array.length; i++) {
			System.out.println(array[i]);
		}

	}
	
	public static int[] stringToArray(String input) {
		int length = input.length();
		int[] intArray = new int[length];
		char[] charArray = new char[length];
		int j = 0;
		
		for(int i = 0; i< length; i++ ) { //transforms string to char array
			charArray[i] = input.charAt(i); 
		}
		
		for(int i =0 ; i< charArray.length; i++) {
			
			if(charArray[i] == ',') {
				j++;
				i++;
			}
			intArray[j] = charArray[i];
			
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
		s = ""; //retrim the string for next iteration

		return s;

	}
}
