import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Kelp {
	
	private int x, y;
	private int vx, vy;
	private Image img;
	private AffineTransform tx;
	
	public Kelp() {
		img = getImage("/imgs/kelp.png");
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
	}
	public Kelp(String kelp) {
		img = getImage("/imgs/kelp.png");
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
	}
	
	
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}
	private void update() {
		tx.setToTranslation(200, 350);
		tx.scale(0.2, 0.2);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Kelp.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
}
