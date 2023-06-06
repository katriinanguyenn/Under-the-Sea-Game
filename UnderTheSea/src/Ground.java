import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Ground{
	private int x, y; //position of the bird
	private int vx, vy; //for movement
	private Image img; 	
	private AffineTransform tx;

	public Ground() {
		
		img = getImage("/imgs/sea background.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y); 				//initialize the location of the image
									//use your variables
		//give the duck a random non-zero velocity between -3 and 3
		// in both x and y direction
		
		/*vx = (int) (Math.random()*7)-3; //use formula for random #
		vy = (int) (Math.random()*7)-3; //use formula for random #
		
		// what happens if vx or vy were initialized to 0?
		while(vx == 0) {
			vx = (int) (Math.random()*7)-3;
		}
		while(vy == 0) {
			vy = (int) (Math.random()*7)-3;
		}  */
		
	}
	//include a constructor that allows specifying the file name od the image
	public Ground(String background) {
		img = getImage("/imgs/" + background); 
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
		
		x = x + vx;
		y = y + vy;
		
		//borders
		if(x > 800 || x < 0) {
			vx = -vx;
		}
		if(y > 500 || y < 0) {
			vy = -vy;
		}
		
		
		
		update();
		g2.drawImage(img, tx, null);
		

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 0.5);
	}
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(5, 5.7);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ground.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
