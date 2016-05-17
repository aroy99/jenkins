package komorebi.jenkins.entity;


public abstract class Entity {
	protected float x, y, sx, sy, dx, dy;
	protected float ox, oy, radius;
	
	public Entity(float x, float y, float sx, float sy){
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		ox=x+sx/2;
		oy=y+sy/2;
		radius=sx/2;
	}
	public abstract void update();
	public abstract void render();
	
	public float getX() {
		return this.x;
	}
	public float getY() {
		return this.y;
	}
	
	public float getSx() {
		return this.sx;
	}
	public float getSy() {
		return this.sy;
	}
	
	public float getDx() {
		return this.dx;
	}
	public float getDy() {
		return this.dy;
	}
	
	public float getOx(){
		return this.ox;
	}
	public float getOy(){
		return this.oy;
	}
	public void setDx(float dx) {
		this.dx = dx;
	}
	
	public void setDy(float dy) {
		this.dy = dy;
	}
	public float getRadius() {
		return radius;
	}
	public abstract void kill();
	public abstract void fall();
	
	
	
}
