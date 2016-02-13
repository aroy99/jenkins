package komorebi.game.entity;

public abstract class Entity {
	protected float x, y, sx, sy, dx, dy;
	protected Draw draw;
	
	public abstract void update();
	public abstract void render();
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	public float getSx() {
		return sx;
	}
	public float getSy() {
		return sy;
	}
	
	
}
