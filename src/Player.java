import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter{
	
	GameFrame gf;
	public Player(GameFrame gf) {
		// TODO Auto-generated constructor stub
		this.gf = gf;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyNum = e.getKeyCode();
//		System.out.println(keyNum);
		switch(gf.gameState) {
			case 0: 
				gf.gameState = 1;
				gf.enemies.clear();
				break;
			case 1:
				switch(keyNum) {
				case 37:
					gf.hp.left = true;
					break;
				case 38:
					gf.hp.up = true;
					break;
				case 39:
					gf.hp.right = true;
					break;
				case 40:
					gf.hp.down = true;
					break;
				case 90:
					attack();
				}
				break;
			case 2:
				switch(keyNum) {
				case 38:
					gf.endX = (GameFrame.bgWidth-177)/2-30;
					gf.endY = (GameFrame.bgHeight-76)/2+65;
					break;
				case 40:
					gf.endX = (GameFrame.bgWidth-177)/2-30;
					gf.endY = (GameFrame.bgHeight-76)/2+165;
					break;
				case 90:
					if(gf.endY == (GameFrame.bgHeight-76)/2+65) {
						gf.gameState = 1;
					}
					else {
						gf.gameState = 0;
					}
					gf.enemies.clear();
					gf.hp.x = (GameFrame.bgWidth-40)/2;
					gf.hp.y = (GameFrame.bgHeight-100);
					gf.hpd = null;
				}
		}
		
	}

	private void attack() {
		// TODO Auto-generated method stub
		Bullet bullet = new Bullet(gf.hp.x+(gf.hp.width-Bullet.width)/2,gf.hp.y);
		bullet.start();
		gf.bullets.add(bullet);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyNum = e.getKeyCode();
		switch(keyNum) {
			case 37:
				gf.hp.left = false;
				break;
			case 38:
				gf.hp.up = false;
				break;
			case 39:
				gf.hp.right = false;
				break;
			case 40:
				gf.hp.down = false;
		}
	}
	
}
