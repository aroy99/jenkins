/*
 * AimedBullet.java           Feb 13, 2016
 */

package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Physics;
import komorebi.jenkins.states.Game;


/**
 * A bullet fired towards the players position
 * 
 * @author Aaron Roy
 * @version 0.0.2.0
 * 
 */
public class AimedBullet extends Bullets {
	
	Player target;
	private float targetX;
	private float targetY;
	private double theta;
	public boolean isVisible;

	public AimedBullet(float x, float y, BulletSize size, BulletColor color, Player target, float speed) {
		super(x, y, size, color);
		this.target = target;
		
        ox=x+sx/2;
        oy=y+sy/2;

        targetX=target.getOx();
        targetY=target.getOy();
        
        float trix = ox-targetX;
        float triy = oy-targetY;
		
		theta = Math.atan(triy/trix);
		dy = (float) Math.sin(theta) * speed;
		dx = (float) Math.cos(theta) * speed;
		
	    radius=sx/2;
		
	}

	public AimedBullet(float x, float y, BulletSize size, BulletColor color) {
		super(x,y,size, color);
		this.color = BulletColor.RED;
		this.size = BulletSize.MEDIUM;
		this.isVisible = false;
	}
	
	public void shootAimed(float x, float y, BulletSize size, BulletColor color, Player target, float speed) {
		this.target = target;
		this.x = x;
		this.y = y;
		
        ox=x+sx/2;
        oy=y+sy/2;

		
		targetX=target.getOx();
		targetY=target.getOy();
		
		float trix = ox-targetX;
		float triy = oy-targetY;
		
		theta = Math.atan(triy/trix);
		dy = (float) Math.sin(theta) * speed;
		dx = (float) Math.cos(theta) * speed;
		
		this.isVisible = true;
		radius=sx/2;
		this.color = color;
		this.size = size;
	}
	
	@Override
	public boolean collided() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		x+=dx;
		y+=dy;
		ox+=dx;
		oy+=dy;
		
		if(Physics.checkPlayer(Game.getPlayer(),this))System.out.println("You ded");
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}
	
}
