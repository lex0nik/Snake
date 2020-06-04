package fidaki;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private ImageIcon titleImage;
	private int[] fidakiX = new int[750];
	private int[] fidakiY = new int[750];
	private int[] adipalosX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] adipalosY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	private ImageIcon adipalosimage;
	private int score = 0;
	private Random random = new Random();
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon katwstoma;
	private ImageIcon deksiastoma;
	private ImageIcon aristerastoma;
	private ImageIcon panwstoma;
	int moves=0;
	
	
	private int lengthFidaki = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon fidakiimage;
	
	
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer (delay, this);
		timer.start();
		
		
		
		
	}
	
	public void paint(Graphics g){
		
		if(moves==0) {
			fidakiX[2]=50;
			fidakiX[1]=75;
			fidakiX[0]=100;
		
			fidakiY[2]=100;
			fidakiY[1]=100;
			fidakiY[0]=100;
		
		}
		
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores: "+ score, 780, 30);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: "+ lengthFidaki, 780, 50);
		
		deksiastoma = new ImageIcon("deksiastoma.png");
		deksiastoma.paintIcon(this, g, fidakiX[0], fidakiY[0]);
		
		for(int a=0;a<lengthFidaki;a++) {
			if(a==0 && right) {
				deksiastoma = new ImageIcon("deksiastoma.png");
				deksiastoma.paintIcon(this, g, fidakiX[a], fidakiY[a]);
			}
			
			if(a==0 && left) {
				aristerastoma = new ImageIcon("aristerastoma.png");
				aristerastoma.paintIcon(this, g, fidakiX[a], fidakiY[a]);
			}
			
			if(a==0 && up) {
				panwstoma = new ImageIcon("panwstoma.png");
				panwstoma.paintIcon(this, g, fidakiX[a], fidakiY[a]);
			}
			
			if(a==0 && down) {
				katwstoma = new ImageIcon("katwstoma.png");
				katwstoma.paintIcon(this, g, fidakiX[a], fidakiY[a]);
			}
			
			if(a!=0) {
				fidakiimage = new ImageIcon("fidakiimage.png");
				fidakiimage.paintIcon(this, g, fidakiX[a], fidakiY[a]);
			}
			
		}
		
		adipalosimage = new ImageIcon("enemy.png");
		if((adipalosX[xpos]==fidakiX[0]) && (adipalosY[ypos]==fidakiY[0])) {
			score++;
			lengthFidaki++;
			xpos=random.nextInt(34);
			ypos=random.nextInt(23);
		}	
		adipalosimage.paintIcon(this, g, adipalosX[xpos], adipalosY[ypos]);
		
		
		for(int b = 1; b<lengthFidaki; b++) {
			if(fidakiX[b] == fidakiX[0]  &&  fidakiY[b]==fidakiY[0]) {
				right=false;
				left=false;
				up=false;
				down=false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("POULO EXASES", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("PATA SPACE RE", 350, 340);
			}
		}
		
		g.dispose();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right) {
			for(int r = lengthFidaki-1;r>=0;r--) {
				fidakiY[r+1] = fidakiY[r];
			}
			for(int r = lengthFidaki;r>=0;r--) {
				if(r==0) {
					fidakiX[r]=fidakiX[r] + 25; 
				}
				else {
					fidakiX[r]=fidakiX[r-1]; 
				}
				if(fidakiX[r]>850) {
					fidakiX[r]=25;
				}
				
			}
			repaint();
		}
		
		if(left) {
			for(int r = lengthFidaki-1;r>=0;r--) {
				fidakiY[r+1] = fidakiY[r];
			}
			for(int r = lengthFidaki;r>=0;r--) {
				if(r==0) {
					fidakiX[r]=fidakiX[r] - 25; 
				}
				else {
					fidakiX[r]=fidakiX[r-1]; 
				}
				if(fidakiX[r]<25) {
					fidakiX[r]=850;
				}
				
			}
			repaint();
		}
		
		if(down) {
			for(int r = lengthFidaki-1;r>=0;r--) {
				fidakiX[r+1] = fidakiX[r];
			}
			for(int r = lengthFidaki;r>=0;r--) {
				if(r==0) {
					fidakiY[r]=fidakiY[r] + 25; 
				}
				else {
					fidakiY[r]=fidakiY[r-1]; 
				}
				if(fidakiY[r]>625) {
					fidakiY[r]=75;
				}
				
			}
			repaint();
		}
		
		if(up) {
			for(int r = lengthFidaki-1;r>=0;r--) {
				fidakiX[r+1] = fidakiX[r];
			}
			for(int r = lengthFidaki;r>=0;r--) {
				if(r==0) {
					fidakiY[r]=fidakiY[r] - 25; 
				}
				else {
					fidakiY[r]=fidakiY[r-1]; 
				}
				if(fidakiY[r]<75) {
					fidakiY[r]=625;
				}
				
			}
			repaint();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves=0;
			score=0;
			lengthFidaki=3;
			repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right=true;
			if(!left) {
				right = true;
			}
			else {
				right=false;
				left=true;
			}
			down=false;
			up=false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left=true;
			if(!right) {
				left = true;
			}
			else {
				left=false;
				right=true;
			}
			down=false;
			up=false;
			
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up=true;
			if(!down) {
				up = true;
			}
			else {
				up=false;
				down=true;
			}
			right=false;
			left=false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down=true;
			if(!up) {
				down = true;
			}
			else {
				down=false;
				up=true;
			}
			right=false;
			left=false;
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
