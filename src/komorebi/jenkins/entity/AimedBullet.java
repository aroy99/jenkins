package komorebi.jenkins.entity;

import komorebi.jenkins.engine.Draw;
import komorebi.jenkins.engine.Physics;
import komorebi.jenkins.states.Game;

public class AimedBullet extends Bullets {
	
	Player target;
	private float targetX;
	private float targetY;
	private double theta;
	public boolean isVisible;

	public AimedBullet(float x, float y, BulletSize size, BulletColor color, Player target, float speed) {
		super(x, y, size, color);
		this.target = target;
		
		targetX=target.getX();
		targetY=target.getY();
		
		float trix = x-targetX;
		float triy = y-targetY;
		
		theta = Math.atan(triy/trix);
		dy = (float) Math.sin(theta) * speed;
		dx = (float) Math.cos(theta) * speed;
		
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
		
		targetX=target.getX();
		targetY=target.getY();
		
		float trix = x-targetX;
		float triy = y-targetY;
		
		theta = Math.atan(triy/trix);
		dy = (float) Math.sin(theta) * speed;
		dx = (float) Math.cos(theta) * speed;
		
		this.isVisible = true;
		ox=x+sx/2;
		oy=y+sy/2;
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
	public void render() {

		Draw.drawRect(x, y, 29, 29, 0, 67, 29, 96, 0);
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
