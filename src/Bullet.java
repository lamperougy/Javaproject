import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet extends Thread{
	int x,y;
	static int width = 20, height = 20;
	int speed = 10;
	boolean alive = true;
	Image img = new ImageIcon("img/bullet1.png").getImage();
	
	public Bullet(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void run() {
		while(alive) {
			y -= speed;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
