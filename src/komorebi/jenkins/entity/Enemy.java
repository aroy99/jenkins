package komorebi.jenkins.entity;

import java.util.ArrayList;

public abstract class Enemy extends Entity {
	
	public Enemy(float x, float y, float sx, float sy) {
		super(x, y, sx, sy);
	}
	private static int straightCount = -1;
	private static int aimedCount = -1;
	
	public static AimedBullet[] aimedBullets = new AimedBullet[2000];
	private static ArrayList<StraightBullet> straightBullets = new ArrayList<StraightBullet>();
	
	public static void loadBullets() {
		for (int i =0; i<2000; i++) {
			straightBullets.add(new StraightBullet(null, null));
			aimedBullets[i] = new AimedBullet(12, 13, Bullets.BulletSize.LARGE, Bullets.BulletColor.VIOLET);
		}
	}
	
	public static StraightBullet getStraightBullet() {
		straightCount++;
		
		if (straightCount>1999) {
			straightCount=0;
		}
		
		return straightBullets.get(straightCount);
		
	}
	
	public static AimedBullet getAimedBullet() {
		aimedCount++;
		
		if (aimedCount>1999) {
			aimedCount=0;
		}
		
		return aimedBullets[aimedCount];
	}
	
	public abstract void attack();
	
	public void update() {
		this.x += this.dx;
		this.y += this.dy;
	}

	
	public abstract void render();
	public abstract void fall();
	public abstract void kill();
}
