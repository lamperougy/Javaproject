import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	/**
	 * 雷霆战机主程序
	 */
	private static final long serialVersionUID = 3104993855195594002L;
	static int bgWidth = 540, bgHeight = 960;//背景尺寸
	int bgSpeed = -1;//背景滚动速度
	int bgY = 0;//背景相对位置
	HeroPlane hp;//英雄机
	HeroPlaneDie hpd;
	Vector<Bullet>bullets = new Vector<>();
	Vector<EnemyPlane>enemies = new Vector<>();
	Vector<BombedEp>bEps = new Vector<>();
	int epSpeed = 500;//敌机出现速度
	int gameState = 0;//游戏状态，0，未开始，1，正在游戏，2，游戏结束。
	int endX = (bgWidth-177)/2-30,endY = (bgHeight-76)/2+65;
	public GameFrame() {
		hp = new HeroPlane((bgWidth-40)/2,(bgHeight-100));//英雄机
		hp.start();

		this.setSize(bgWidth, bgHeight);
		this.setTitle("雷霆战机");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//面板绘制线程
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			}
		}).start();
		
		//随机生成敌机线程
		new Thread(new Runnable() {
			public void run() {
				Random r = new Random();
				while(true) {
					EnemyPlane ep = new EnemyPlane(r.nextInt(GameFrame.bgWidth-EnemyPlane.width),0);
					ep.start();
					enemies.add(ep);
					try {
						Thread.sleep(r.nextInt(epSpeed*2));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		this.setVisible(true);
	}
	
	//绘制游戏面板
	public void paint(Graphics g) {
//		System.out.println("绘制");
		BufferedImage image = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
		Graphics bi = image.getGraphics();
		//绘制背景
		bgY -= bgSpeed;
		bgY = bgY%this.getSize().height;
		//背景图绘制并具有移动效果
		bi.drawImage(new ImageIcon("img/background4.jpg").getImage(), 0, 0, null);
		
		
		switch(gameState) {
			case 0://游戏开始前
				bi.drawImage(new ImageIcon("img/start3.png").getImage(), 50, 412, 412, 120, null);
				bi.drawImage(new ImageIcon("img/start2.png").getImage(), 50, 690, 412, 60, null);
				break;
			default://游戏开始
				//准备被击毁的敌机					
				for(int i=0;i<enemies.size();i++) {
					EnemyPlane ep = enemies.get(i);
					Rectangle recEp = new Rectangle(ep.x,ep.y,EnemyPlane.width,EnemyPlane.height);
					for(int j=0;j<bullets.size();j++) {
						Bullet bullet = bullets.get(j);
						Rectangle recB = new Rectangle(bullet.x,bullet.y,Bullet.width,Bullet.height);
						if(recB.intersects(recEp)) {
							enemies.get(i).alive = false;
							enemies.remove(i);
							bullets.get(j).alive = false;
							bullets.remove(j);
							BombedEp bEp = new BombedEp(ep.x,ep.y);
							bEp.start();
							bEps.add(bEp);
							break;
						}
					}				
				}
				
				//准备英雄机被击毁
				for(int i=0;i<enemies.size();i++) {
					EnemyPlane ep = enemies.get(i);
					Rectangle recEp = new Rectangle(ep.x,ep.y,EnemyPlane.width,EnemyPlane.height);
					Rectangle recB = new Rectangle(hp.x,hp.y,hp.width,hp.height);
					if(recB.intersects(recEp)) {
						hpd = new HeroPlaneDie(hp.x,hp.y);
						gameState = 2;
					}				
				}

				//绘制英雄机
				if(gameState == 1) bi.drawImage(hp.img, hp.x, hp.y, hp.width, hp.height, null);
				
				//绘制子弹
				for(int i=0;i<bullets.size();i++) {
					Bullet bullet = bullets.get(i);
					if(bullet.y<=0) bullets.remove(bullet);
					else bi.drawImage(bullet.img, bullet.x, bullet.y, Bullet.width, Bullet.height, null);
				}
				//绘制敌机
				for(int i=0;i<enemies.size();i++) {
					EnemyPlane ep = enemies.get(i);
					if(ep.y>= GameFrame.bgHeight) enemies.remove(ep);
					else {
						bi.drawImage(ep.img, ep.x, ep.y, EnemyPlane.width, EnemyPlane.height, null);
					}
				}
				//绘制敌机残骸
				for(int i=0;i<bEps.size();i++) {
					BombedEp bEp = bEps.get(i);
					if(bEp.x == -40) bEps.remove(bEp);
					else bi.drawImage(bEp.img, bEp.x, bEp.y, BombedEp.width, BombedEp.height, null);
				}
				//绘制英雄机残骸
				if(gameState == 2) {
					bi.drawImage(hpd.img, hpd.x, hpd.y, hpd.width, hpd.height, null);
					bi.drawImage(new ImageIcon("img/gameover.png").getImage(), (bgWidth-400)/2, (bgHeight-260)/4, null);
					bi.drawImage(new ImageIcon("img/end1.png").getImage(), (bgWidth-177)/2+50, (bgHeight-76)/2+50, null);
					bi.drawImage(new ImageIcon("img/end2.png").getImage(), (bgWidth-177)/2+50, (bgHeight-76)/2+146, null);
					bi.drawImage(hp.img, this.endX, this.endY, 50, 50, null);
				}
		}		
		g.drawImage(image, 0, 0, null);
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		Player player = new Player(gf);
		gf.addKeyListener(player);
	}
}
