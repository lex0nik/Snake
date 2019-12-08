package fidaki;
import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		obj.setBackground(Color.DARK_GRAY);
		obj.setBounds(10,10, 905, 700);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setResizable(false);
		obj.add(gameplay);
		
	}

}
