import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Pufferfish extends MeanAnimals{

	public boolean dead;
	private Image img; 	//for the image to show up
	private AffineTransform tx; 
	
	
	public Pufferfish() {
		
		super();
		
	}
	public Pufferfish(String fileName) {
		img = getImage("/imgs/" + fileName); 
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		Reset();
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
	
	protected void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.5, 1.5);
	}
	protected void update() {
		//stops the shark from moving backwards
		if(x < 0) {
			vx = -vx;
		}
		
		//when the shark leaves the screen, the hark will restart on the left side 
		//of the screen at a random y position
		if(x > 1200) {
			x = 0;
			y = (int) (Math.random() * 450) - 10;
		}
		
		x = x + vx;
		y = y + vy;
		
		tx.setToTranslation(x, y);
		tx.scale(1.2, 1.2);
	}

	protected Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Pufferfish.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	/*public void Reset() {
		
		dead = false;
		
		y = (int)(Math.random()*500);
		vx = (int) (Math.random()*7)-3;
		

		while(vx == 0) {
			vx = (int) (Math.random()*7)-3;
		}

	}
	
	*/
	
}
