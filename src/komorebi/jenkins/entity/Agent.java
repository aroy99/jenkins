package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Difficulty;
import komorebi.jenkins.engine.Draw;
import komorebi.jenkins.engine.GameHandler;
import komorebi.jenkins.states.Game;

public class Agent extends Enemy {
	
	private int count = 0;
	private int surrenderCount = 0;
	private int framesPerShot;
	private float minY;
	private int surrenderPoint = 1200;
	private Bullets.BulletColor color;
	private boolean isRetreating = false;
	private Bullets.BulletSize size;
	private int lives = 150;
	private boolean stopShooting;
	
	public Agent(float dx, float dy,float x, Bullets.BulletColor color, float minimumY, Bullets.BulletSize size) {
		super(10,300, 16,32);
		this.minY = minimumY;
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		this.size = size;
		
		if      (GameHandler.getDifficulty()==Difficulty.EASY)    framesPerShot = 120;
		else if (GameHandler.getDifficulty()==Difficulty.NORMAL)  framesPerShot = 90;
		else if (GameHandler.getDifficulty()==Difficulty.HARD)    framesPerShot = 60;
		else if (GameHandler.getDifficulty()==Difficulty.LUNATIC) framesPerShot = 30;

	}
	
	public void attack() {
		Enemy.getAimedBullet().shootAimed(x, y, size, color, Game.getPlayer(), 2);
		System.out.println("Bullet Fired");
	}
	
	public void render() {
		Draw.rect(x, y, 17, 29, 149, 0, 166, 29, 0);
	}

	@Override
	public void fall() {
		
		
	}

	@Override
	public void kill() {
		
		
	}
	
	public void receiveHit() {
		if (lives>0) {
			lives--;
		}
		
		if (lives<=0) {
			kill();
		}

	}
	@Override
	public void update() {
		
		if (this.y<=this.minY && !isRetreating) {
			this.y = this.minY;
			this.dy = 0;
			this.dx = 0;
		} else if (isRetreating) {
			this.dy = 1;
			switch(GameHandler.getDifficulty()){
			case EASY:    framesPerShot = 5;break;
			case NORMAL:  framesPerShot = 4;break;
			case HARD:    framesPerShot = 3;break;
			case LUNATIC: framesPerShot = 2;break;
			}
		}
		
		if(y>=400)stopShooting = true;
		
		count++;
		surrenderCount++;
		
		if (count>=this.framesPerShot && !stopShooting) {
			attack();
			count=0;
		}
		
		if (surrenderCount>=surrenderPoint) {
			isRetreating = true;
		}
		
		this.x += this.dx;
		this.y += this.dy;
		
	}
}
