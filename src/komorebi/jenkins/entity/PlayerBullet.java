/*
 * PlayerBullet.java           Feb 13, 2016
 */

package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Draw;

/**
 * A bullet shot by the player
 * 
 * @author Aaron Roy
 * @version 0.0.2.0
 * 
 */
public class PlayerBullet extends Entity{

	float hitsx, hitsy;
	public PlayerBullet(float x, float y) {
		super(x, y, 4,7);
		dy = 5;
	}

	@Override
	public void update() {
		y+=dy;
		
	}

	@Override
	public void render() {
		Draw.rect(x, y, sx, sy, 48, 38, 52, 45, 0);
		
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
