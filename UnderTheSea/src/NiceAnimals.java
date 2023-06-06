import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class NiceAnimals {

	protected int x, y;
	protected int vx, vy;
	private Image img;
	private AffineTransform tx;
	protected boolean dead;
	protected int score;
	
	
	public NiceAnimals() {
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		y = (int) (Math.random() * 450) - 10;
		
		vx = (int) (Math.random()* 7) - 3;
		
		while(vx == 0) {
			vx = (int) (Math.random()* 7) - 3;
		}
		
	}
	
	public NiceAnimals(String fileName) {
		img = getImage("/imgs/" + fileName); 
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		update();
		g2.drawImage(img, tx, null);
	}
	
	protected void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.5, 1.5);
	}
	
	protected void update() {
		if(x < 0) {
			vx = -vx;
		}
		if(x > 1100) {
			x = 0;
			y = (int) (Math.random() * 450) - 10;
		}
		
		x = x + vx;
		y = y + vy;
		
		tx.setToTranslation(x, y);
		tx.scale(0.5, 0.5);
	}
	
	protected Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Angelfish.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	protected boolean die(Bullet b) {
		
		//represents the bullet as a rectangle object
		Rectangle m = new Rectangle(b.getX(), b.getY(), 25, 25);
		//represents the animal as a rectangle object
		Rectangle d = new Rectangle(x, y, 50, 50);
		
		if(m.intersects(d)) { //checks to see if they interact
			vy = 5; //when they interact, vy makes the animal fall off the screen
			vx = 0;
			dead = true;
			return true;
		}
		return false;
	}
	
	protected void Reset() {
		
		dead = false;
		x = 0;
		vy = 0;
		y = (int) (Math.random() * 450) - 10;
		vx = (int) (Math.random()*7) - 3;
	
		while(vx == 0) {
			vx = (int) (Math.random()*7)-3;
		}

	}
	
	
	
}
