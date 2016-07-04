import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;

public class Enemy extends Entity{
	
	public Enemy(int x,int y){ 
		super(x,y);
	}
	public void update(){
		
	}
	public void draw(Graphics2D g2d){
		g2d.drawImage(getEnemyImg(),x,y,50,50,null);
	}
	public Image getEnemyImg(){
		ImageIcon ic = new ImageIcon("man.gif");
		return ic.getImage();
	}

}