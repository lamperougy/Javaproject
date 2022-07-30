import java.awt.Image;

import javax.swing.ImageIcon;

public class HeroPlaneDie {
	int x,y;
	int width = 40, height = 40;
	Image img = new ImageIcon("img/bomb1.png").getImage();
	public HeroPlaneDie(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
