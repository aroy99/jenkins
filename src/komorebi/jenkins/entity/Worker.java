/*
 * Worker.java           Feb 13, 2016
 */

package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Difficulty;
import komorebi.jenkins.engine.Draw;
import komorebi.jenkins.engine.GameHandler;

/**
 * The Worker enemy, can be male or female
 * 
 * @author Aaron Roy
 * @version 0.0.2.0
 * 
 */
public class Worker extends Enemy {
	
	Bullets.BulletColor color;
	Bullets.BulletSize size;
	private boolean isMale;
	private int count = 0;
	private int framesPerShot;
	private Difficulty difficulty;
	
	public Worker(int dx, int dy, Bullets.BulletSize size, boolean isMale, Bullets.BulletColor color) {
		super(0,0,16,32);
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		this.size = size;
		this.isMale = isMale;
		difficulty = GameHandler.getDifficulty();
		
		if (this.difficulty==Difficulty.EASY) framesPerShot = 30;
		else if (this.difficulty==Difficulty.NORMAL) framesPerShot = 20;
		else if (this.difficulty==Difficulty.HARD) framesPerShot = 6;
	}
	
	public void attack() {
		Enemy.getStraightBullet().shootStraight(this.x, this.y, size, color);
	}
	
	public void render() {
		Draw.rect(x, y, 16, 24, 0, 0, 16, 24, 0);
	}

	public void kill() {

		
	}


	public void fall() {

		
	}
	
	@Override
	public void update() {
		
		this.x += this.dx;
		this.y += this.dy;
		
		count++;
		
		if (count>=this.framesPerShot) {
			attack();
			count =0;
		}
	}
	

	
	
}
