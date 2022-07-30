import java.awt.Image;
import javax.swing.ImageIcon;

public class BombedEp extends Thread{
	int x,y;
	static int width = 40, height = 40;
	Image img = new ImageIcon("img/bomb1.png").getImage();
	public BombedEp(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		x = -40;
		y = -40;
	}
	
	
}
