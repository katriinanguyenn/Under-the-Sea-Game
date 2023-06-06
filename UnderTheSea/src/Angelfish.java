import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Angelfish extends NiceAnimals {

 	private Image img; 	
	private AffineTransform tx;
	private boolean dead = false;
	public Angelfish() {
		
		super();
	}

	public Angelfish(String fileName) {
		img = getImage("/imgs/" + fileName); 
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		update();
		
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
		tx.setToTranslation(x, y);
		g2.drawImage(img, tx, null);
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
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	
/*public void Reset() {
		
		dead = false;
		
		x = (int)(Math.random()*600);
		y = (int)(Math.random()*500);
		
		vx = (int) (Math.random()*7)-3; 
		vy = (int) (Math.random()*7)-3; 
		
		if(x > 600 || x < 0) {
			vx = -vx;
		}
		if(y > 500 || y < 0) {
			vy = -vy;
			}
		
		while(vx == 0) {
			vx = (int) (Math.random()*7)-3;
		}
		while(vy == 0) {
			vy = (int) (Math.random()*7)-3;
		}
		

	}
	*/
	
}
