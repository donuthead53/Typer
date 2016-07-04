import java.util.Scanner;
import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;
import javax.swing.*;
public class category{
	public static int category(){
		// Scanner input = new Scanner (System.in);
		boolean working = false;
		// System.out.println("Categories");
		// System.out.println("-----------");
		// System.out.println("Science = 1");
		// System.out.println("Food    = 2");
		// System.out.println("Please type in category(1,2)");
		// int choice = input.nextInt();
		String answerCategory = JOptionPane.showInputDialog(null,"Categories\n-----------\nScience    = 1\nFood          = 2\nAnimals    = 3\nPlease select a category(1,2,3)");
		while  (working == false){
			if (Integer.parseInt(answerCategory) != 1 && Integer.parseInt(answerCategory) != 2 && Integer.parseInt(answerCategory) != 3){
				// System.out.println("That was not 1 or 2!");
				// System.out.println("Please type in choice (1,2)");
				// choice = input.nextInt();
				answerCategory = JOptionPane.showInputDialog(null,"Categories\n-----------\nScience    = 1\nFood          = 2\nAnimals    = 3\nThat wasn't(1,2,3)!");
			}
			else{
				working = true;
			}
		}
		return Integer.parseInt(answerCategory);
	}
}