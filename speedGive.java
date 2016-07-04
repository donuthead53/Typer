// import java.util.Scanner;
import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;
import javax.swing.*;
public class speedGive{
	boolean working = false;
	public static int speed(){
		// Scanner input = new Scanner (System.in);
		boolean working = false;
		// System.out.println("Levels");
		// System.out.println("-----------");
		// System.out.println("Easy    = 1");
		// System.out.println("Medium  = 2");
		// System.out.println("Hard    = 3");
		// System.out.println("Please type in a difficulty(1,2,3)");
		// int speed = input.nextInt();
		String answerSpeed = JOptionPane.showInputDialog(null,"Difficulty\n-----------\nEasy         = 1 (Slow)\nNormal    = 2 (Medium)\nHard         = 3 (Fast)\nPlease select a a difficulty(1,2,3)");
		while  (working == false){
			if (Integer.parseInt(answerSpeed) != 1 && Integer.parseInt(answerSpeed) != 2 && Integer.parseInt(answerSpeed) != 3){
				answerSpeed = JOptionPane.showInputDialog(null,"Difficulty\n-----------\nEasy         = 1 (Slow)\nNormal    = 2 (Medium)\nHard         = 3 (Fast)\nThat was not(1,2,3)!");
			}
			else{
				working = true;
			}
		}
		return Integer.parseInt(answerSpeed);
	}
}