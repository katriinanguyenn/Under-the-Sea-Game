import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Submarine {

	protected int x = 850; //position of the submarine
	protected int y;
	private int vx = 0; //for movement
	private int vy = 0;
	private Image img; 	
	private AffineTransform tx;
	
	
	public Submarine() {
		img = getImage("/imgs/submarine.png"); //load the image for submarine
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
	}
	public Submarine(String fileName) {
		img = getImage("/imgs/" + fileName); 
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		update();
		g2.drawImage(img, tx, null);
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.5, 1.5);
	}
	private void update() {
		
		y = y + vy; //updates the velocity
		
		tx.setToTranslation(x, y);
		tx.scale(1.15, 1.15);
		
		if(y > 500 || y < 0) {
			vy = -vy; // sets the boundaries at the top and bottom of the screen
		}
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Submarine.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	public void up() {
		
		vy = -4; //sets the velocity of the submarine
		
		
		if(vy > 0) {  
			y = y - vy;  //allows the submarine to move upwards
		}
		
	}
	public void down() {
		
		vy = 4; //sets the velocity of the submarine
		
		if(vy > 0) {
			y = y + vy; //allows the submarine to move downwards
		}
		
	
	}
	public void stop() {
		vy = 0; //one the up or down arrow key is released, the submarine stops moving
	}
	
	
	//getters for x and y
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	
	
	
}
