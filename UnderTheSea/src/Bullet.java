import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bullet extends Submarine{

	private int x = 850;
	private int y;
	private int vx = 0;; //for movement
	private int vy = 0;
	private Image img; 	
	private AffineTransform tx;
	
	Rectangle bul= new Rectangle(x, y, 25, 25);
	
	public Bullet() {
		img = getImage("/imgs/bullet.png"); //load the image for submarine
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
	}
	public Bullet(String fileName) {
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
		
		x = x - vx; //updates the velocity
		
		tx.setToTranslation(x, y+10);
		tx.scale(0.5, 0.5);

		if(x > 1000) {
			vx = -vx; // sets the boundaries at the top and bottom of the screen
		}
		
		if(x < 0) {
			x = 850;
			vx = 0;
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
	
	public void move() {
		vx = 4;
		x = x - vx;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	
	
	
	
}
