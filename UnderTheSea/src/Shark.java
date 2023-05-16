import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Shark {

	private int x, y; //position of the submarine
	private int vx, vy; //for movement
	private Image img; 	
	private AffineTransform tx;
	
	
	public Shark() {
		img = getImage("/imgs/shark.png"); //load the image for submarine
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
		y = (int) (Math.random() * 450) - 10;
		
		vx = (int) (Math.random()* 7) - 3;
		
		while(vx == 0) {
			vx = (int) (Math.random()* 7) - 3;
		}
		
		
	}
	public Shark(String fileName) {
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
		tx.scale(1.2, 1.2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Shark.class.getResource(path);
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
