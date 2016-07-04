//Justin Duong
//ICS3U1
//Ms.Strelkovska
//April 11th 2014
//STRING GAME
import java.awt.*; 
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class MyGame extends JPanel implements ActionListener {
	ImageIcon icon;
	public JLabel label2;
    public JButton Button;
    public JLabel label;
    public JTextField text1;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ImageIcon man ;
    ImageIcon pixel[]= new ImageIcon[5];
    int x=0;
    int y=0;
	int score=0;
    Timer myTime;
    Color c = Color.black;
	int enemyCount = 100;
	int p[]= new int[enemyCount];
	static ArrayList<String> words = new ArrayList<String>();
	boolean visible[]=new boolean[enemyCount];
	int int_sec=0;
	int int_min=0;
	int int_mil=0;
	double startTime;
	speedGive value = new speedGive();
    int speeding = value.speed();
	category value2 = new category();
    int category = value2.category();
    double seconds = 0.0;
	Scanner scHighScoreName = new Scanner(new File("notHighScore.txt"));
	String inputName = scHighScoreName.nextLine();
	Scanner scHighScore = new Scanner(new File("notScore.txt"));
	String inputScore = scHighScore.nextLine();
	int highscore = Integer.parseInt(inputScore);
	String highscoreName = inputName;
 
    
	public MyGame() throws Exception{
		
		//In retrospect, this random word import thing seemed very easy but after much diligence and hard work this is not working.
		//So I gave up on random words but the actually code is still there but I could throw exceptions in the paint method and I couldn't bring variables
		//from other methods into it, I even tried making another Java class and making method there but It just couldn't work without.
		// Scanner scFile = new Scanner(new File("dict.txt")); 
		// String in = scFile.nextLine();
		// String[] list = in.split(" ");
		// Random rand = new Random();
		// int  n = rand.nextInt(list.length) + 1;
		// String words = list[n];
		// System.out.println(words);
		// randomWord qwer = new randomWord();
		// String acdc = qwer.randomWord();
		// System.out.println(acdc);
		//-----------------------------
		// label = new JLabel();
		// label.setText("Super Typing Game");
		// Button = new JButton("Play Game");
		// add(label2);
		// add(Button);
		// Button.addActionListener(this);
		//-----------------------------
	    File file = new File("notHighScore.txt");
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(highscoreName);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Super Typing Game\n--------------------------------\nThe objective of the game is to try to acquire\n as many points as possible during a time span\nof 30 seconds. How you get points is that\n you have to type the words on the screen to get points.\n The amount of points is based on the length of the word you typed.\n\nCURRENT HIGHSCORE: \""+highscoreName+"\" with "+ highscore+" points");
		myTime = new Timer(30,this);
		Random rand = new Random();
		for(int i=0;i<visible.length;i++){
			visible [i]= true;
		}
		// for(int i = 0;i<pixel.length;i++){
			// pixel[i] = new ImageIcon("man.gif");
		// }
		// for(int i = 0;i<word.length;i++){
			// word[0] = 
		// }
		if (category == 1){
			Scanner scFile = new Scanner(new File("science.txt"));
			String input = scFile.nextLine();
			String[] listz = input.split(" ");
			for (int i = 0;i<enemyCount;i++){
				int  n = rand.nextInt(listz.length);
				words.add(listz[n]);
			}
		}
		else if (category == 2){
			Scanner scFile = new Scanner(new File("food.txt"));
			String input = scFile.nextLine();
			String[] listz = input.split(" ");
			for (int i = 0;i<enemyCount;i++){
				int  n = rand.nextInt(listz.length);
				words.add(listz[n]);
			}
		}
		else if (category == 3){
			Scanner scFile = new Scanner(new File("animals.txt"));
			String input = scFile.nextLine();
			String[] listz = input.split(" ");
			for (int i = 0;i<enemyCount;i++){
				int  n = rand.nextInt(listz.length);
				words.add(listz[n]);
			}
		}
		text1 = new JTextField(10);
		text1.addActionListener(this);
		
		//c.add(text1);
		//Labels or Text
		label = new JLabel();
		label.setText("Type in the words on the screen");

		add(text1);
		add(label);
		myTime.start();
		for(int i=0; i<enemyCount;i=i+1){
			p[i] = rand.nextInt(300);
			int x1=x+i*-30;
			int y1=p[i];
			addEnemy(new Enemy(x1,y1));
		}
		startTime = System.currentTimeMillis();
	}
	public void actionPerformed(ActionEvent e) {
		//-----------------------------
		// JFrame frame = new JFrame("Typing Game");
		// JButton b = (JButton)e.getSource();
		// String act = b.getActionCommand();
		// if (act.equals("Play Game")){
			// add(new MyGame());
		// }
		//-----------------------------
		//JOptionPane.showMessageDialog(null, "The sum is " + text1.getText(), "Results",JOptionPane.PLAIN_MESSAGE );
		if (e.getSource() == text1){
			for(int i=0;i<enemies.size();i++){
				if(text1.getText().equals(words.get(i)) && visible[i] ){
					int wurd = (words.get(i).length());
					visible[i] = false;
					text1.setText("");
					score=score+wurd;
				}
			}
			text1.setText("");
		}
		//if(text1.getText().equals(label.getText())){
      //  	label.setForeground(Color.green);
       // 	c=Color.green;
		//else
		else if(e.getSource()==myTime){
			repaint();
			//x+=speeding;
			//y+=10;
		}
		x+=speeding;
		for (int i = 0;i<enemies.size();i=i+1){
			if (visible[i]){
				Enemy tempEnemy = enemies.get(i);
				tempEnemy.update();
			}
		}
		double elapsed = (System.currentTimeMillis() - startTime);
		seconds = (elapsed/1000.0);
		System.out.println(seconds);
		if (seconds > 30){
			if(highscore<score){
				highscoreName = JOptionPane.showInputDialog(null, "You beat the highscore!\n Please type in your name","");
				try {
				    File file = new File("notHighScore.txt");
				    FileWriter fw = new FileWriter(file.getAbsoluteFile());
				    BufferedWriter bw = new BufferedWriter(fw);
					bw.write(highscoreName);
					bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				try {
				    File file2 = new File("notScore.txt");
				    FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());
				    BufferedWriter bw2 = new BufferedWriter(fw2);
				    bw2.write(Integer.toString(score));
				    bw2.close();
					} catch (IOException e1) {
					e1.printStackTrace();
					}
			}
			String answer = JOptionPane.showInputDialog(null, "Your score is "+ score + ",Play Again?(Y/N)", "Game Over");
			if (answer.equals("Y")){
				
				if (speeding == 1){
					x=500;
				}
				else {
					x=0;
				}
				text1.setText("");
				seconds = 0.0;
				score = 0;
				startTime = System.currentTimeMillis();
			}
			else {
				System.exit(ABORT);
			}
		}
	}
	public Image getEnemyImg(){
		ImageIcon ic = new ImageIcon("man.gif");
		return ic.getImage();
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// for(int i=0;i<pixel.length;i++){
			// int x1=(x);
			// int y1=(y+i*60+50);
			// if (visible[i]){
				// g.drawImage(pixel[i].getImage(),x1,y1,50,50,null);
				// g.drawString(word[i],x1+15,y1+60);
			// }
		//}
		g.drawString("Score: "+score,100,20);
		for (int i = 0;i<enemies.size();i=i+1){
			int x1=x+i*-30;
			int y1=p[i];
			if (visible[i]){
				g.drawImage(getEnemyImg(),x1,y1,50,50,null);
				g.drawString(words.get(i),x1+15,y1+60);
			}
		}
	}
	public void addEnemy(Enemy e){
		enemies.add(e);
	}
	public static void removeEnemy(Enemy e){
		enemies.remove(e);
	}
	public static ArrayList<Enemy> getEnemyList(){
		 return enemies;
	}
	public int value(){
		return speeding;
	}	
	
}



