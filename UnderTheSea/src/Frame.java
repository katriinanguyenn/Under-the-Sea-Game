import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
    
	Submarine sub = new Submarine();
	Kelp k = new Kelp();
	Blobfish b = new Blobfish();
	MeanAnimals s = new Shark("shark.png");
	NiceAnimals a = new Angelfish("angelfish.png");
	Bullet bu = new Bullet();
	NiceAnimals t = new Turtle("turtle!.png");
	MeanAnimals p = new Shark("pufferfish.png");
	MeanAnimals sting = new Stingray("stingray.png");
	MeanAnimals angler = new AnglerFish("anglerfish.png");
	Ground back = new Ground();
	boolean dead;
	int count = 50000;
	int score;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//paints all the graphics
		back.paint(g);
		sub.paint(g);
		k.paint(g);
		b.paint(g);
		s.paint(g);
		a.paint(g);
		t.paint(g);
		p.paint(g);
		sting.paint(g);
		angler.paint(g);
		
		bu.paint(g);
		
		bu.setY(sub.y); // sets the bullet to stay with the submarine
		
		//checks if each animal dies and updates score accordingly
		if(a.die(bu)) {; //check for collision 60x per second
			score = score - 100; // updates score
			dead = true;
			a.Reset();
		}
		if(t.die(bu)) {; //check for collision 60x per second
			score = score - 100; // updates score
			dead = true;
			t.Reset();
		}
		if(s.die(bu)) {
			score = score + 100; // updates score
			dead = true;
			s.Reset();
		}
		if(p.die(bu)) {
			score = score + 100; // updates score
			dead = true;
			p.Reset();
		}
		if(sting.die(bu)) {
			score = score + 100; // updates score
			dead = true;
			sting.Reset();
		}
		if(angler.die(bu)) {
			score = score + 100; // updates score
			dead = true;
			angler.Reset();
		}
		
		
		g.setColor(Color.darkGray);
		g.fillRect(30, 460, 100, 75);
		g.setColor( Color.white);
		Font plainFont = new Font("Candara" ,  Font.PLAIN, 25);
		g.setFont(plainFont);
		g.drawString("Score", 50, 485);
		g.drawString(score + " ", 70, 515);
		
		
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Under The Sea");
		f.setSize(new Dimension(1000, 600));
		f.setBackground(Color.blue); 
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//BufferedImage cursorImg;
		/*try {
				cursorImg =  ImageIO.read(new File("cursor.png"));
				Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
						   cursorImg, new Point(20, 20), "blank cursor");
				f.getContentPane().setCursor(blankCursor);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
		
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
		switch(arg0.getKeyCode()) {
			case 38:
				 sub.up();	
				break;
				
			case 40:
				sub.down();
				break;
				
			case 32:
				bu.move();
				a.die(bu);
				s.die(bu);
				break;
		}
	
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		sub.stop();
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	
	
	
	
	
	
}
