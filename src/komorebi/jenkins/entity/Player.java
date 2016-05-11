/*
 * Player.java            Feb 13, 2016
 */

package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Animation;
import komorebi.jenkins.states.Game;

import org.lwjgl.input.Keyboard;

/**
 * Represents the player
 * 
 * @author Aaron Roy
 * @version 0.0.2.0
 * 
 */
public class Player extends Entity{

	boolean up,down,left,right;
	private boolean focus;
	private final int radius = 2;
	private float ox, oy;
	private boolean isShooting;
	private boolean wasBomb;
	private boolean isBomb;
	private int bombs = 3;
	private int shootCounter;
	private Animation walking;
	
	public Player(){
		super(60, 60, 16, 32);
		ox = x-sx/2;
		oy = y-sy/2;
		walking = new Animation(2, 5, sx, sy, 0);
		walking.add(0,0);
		walking.add(16,0);
	}
	
	
	@Override
	public void fall() {}//used to fulfill the Entity class as all other entities will wipe if off screen.

	public int getBombs(){
	    return bombs;
	}

	public void getInput() {
		up=Keyboard.isKeyDown(Keyboard.KEY_UP) && !Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		down=Keyboard.isKeyDown(Keyboard.KEY_DOWN) && !Keyboard.isKeyDown(Keyboard.KEY_UP);
		
		left=Keyboard.isKeyDown(Keyboard.KEY_LEFT) && !Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
		right=Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && !Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		
		focus = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
		
		isShooting = Keyboard.isKeyDown(Keyboard.KEY_Z);
		
		wasBomb = isBomb;
		isBomb = Keyboard.isKeyDown(Keyboard.KEY_X);
	}
	public float getOX(){
		return ox;
	}
	
	public float getOY(){
		return oy;
	}
	
	public float getRadius(){
		return radius;
	}


	@Override
	public void kill() {
		// loses one full heart when hit
		
	}
	
	@Override
	public void render() {
		walking.play(x,y);
	}


	@Override
	public void update() {
		if(up)dy=3;
		if(down)dy=-3;
		if(left)dx=-3;
		if(right)dx=3;
		if(focus){
			dx/=3;
			dy/=3;
		}
		y+=dy;
		
		x+=dx;
		
		if(y+32+3>294 || y-3<6) y-=dy;
		if(x+24+3>278 || x-3<6) x-=dx;

		ox = x-sx/2;
		oy = y-sy/2;
		
		dy=0;
		dx=0;
		
		
		shootCounter++;
		if(isShooting && shootCounter >3){
			Game.getBullets().add(new PlayerBullet(x+11, y+24));
			shootCounter=0;
		}
		
		if(isBomb && !wasBomb && bombs>0){
			System.out.println("BOOM, " + --bombs + " left");
		}
		
	}
}

