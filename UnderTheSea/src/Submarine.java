import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Submarine {

	private int x, y; //position of the submarine
	private int vx, vy; //for movement
	private Image img; 	
	private AffineTransform tx;
	
	
	public Submarine() {
		img = getImage("/imgs/submarine.png"); //load the image for submarine
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
		vx = 0;
		vy = 10; 
		
		
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
		
		x += vx;
		y += vy;
		
		update();
		g2.drawImage(img, tx, null);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.5, 1.5);
	}
	private void update() {
		tx.setToTranslation(800, 200);
		tx.scale(1.15, 1.15);
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
	
	
	public void move(KeyEvent arg0) {
		
		if(arg0.getKeyCode() == 38) {
			y -= vy;
		}
		if(arg0.getKeyCode() == 40) {
			y += vy;
		}
		
		/*if(y <= 0) {
			y = 0;
		}
		if(y >= 395) {
			y = 395;
		}
		*/
	}
	public void release(KeyEvent arg0) {
		
		if(arg0.getKeyCode() == 38) { 
			vy = 0; 
		}
		if(arg0.getKeyCode() == 40) {
			vy = 0;
		}
	}
	
	
	
	
}
