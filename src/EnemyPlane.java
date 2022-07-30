import java.awt.Image;

import javax.swing.ImageIcon;

public class EnemyPlane extends Thread {

	int x, y;
	static int width = 40, height = 40;
	int speed = 2;
	boolean alive = true;
	Image img = new ImageIcon("img/10021.png").getImage();

	public EnemyPlane(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int k = 0;
		while (alive) {
			y += speed;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (k == 36) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			k = k + 1;

		}


	}
}
