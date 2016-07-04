import javax.swing.JFrame;
public class Main{
	public static void main (String[] args) throws Exception{
		JFrame frame = new JFrame("Typing Game");
		frame.add(new MyGame());
		frame.setSize(800,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}