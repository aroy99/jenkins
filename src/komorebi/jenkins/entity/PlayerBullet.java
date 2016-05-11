package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Draw;

public class PlayerBullet extends Bullets{

	float hitsx, hitsy;
	public PlayerBullet(float x, float y, BulletColor color) {
		super(x, y, BulletSize.PLAYER, color);
		dy = 5;
	}

	@Override
	public boolean collided() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		y+=dy;
		
	}

	@Override
	public void render() {
		Draw.drawRect(x, y, sx, sy, 48, 38, 52, 45, 0);
		
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
