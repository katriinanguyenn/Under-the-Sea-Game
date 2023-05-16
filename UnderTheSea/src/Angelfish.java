import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Angelfish {

	private int x, y; //position of the submarine
	private int vx, vy; //for movement
	private Image img; 	
	private AffineTransform tx;
	
	
	public Angelfish() {
		img = getImage("/imgs/angelfish.png"); //load the image for submarine
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
		y = (int) (Math.random() * 450) - 10;
		
		vx = (int) (Math.random()* 7) - 3;
		
		while(vx == 0) {
			vx = (int) (Math.random()* 7) - 3;
		}
		
		
	}
	public Angelfish(String fileName) {
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
		
		
		update();
		g2.drawImage(img, tx, null);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.5, 1.5);
	}
	private void update() {
		if(x < 0) {
			vx = -vx;
		}
		
		tx.setToTranslation(x, y);
		tx.scale(0.75, 0.75);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Angelfish.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	
	
}
