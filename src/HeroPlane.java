import java.awt.Image;

import javax.swing.ImageIcon;

public class HeroPlane extends Thread {
	int x,y;
	int width = 40, height = 40;
	int speed = 10;
	boolean up,down,left,right;
	Image img = new ImageIcon("img/10013.png").getImage();
	public HeroPlane(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public HeroPlane() {
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(up) {
				y -= speed;
				if(y<0) y=0;
			}
			if(down) {
				y += speed;
				if(y>780) y = 780;
			}
			if(left) {
				x -= speed;
				if(x<0) x=0;
			}
			if(right) {
				x += speed;
				if(x>500) x=500;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
