package komorebi.jenkins.entity;


public class StraightBullet extends Bullets{

	private boolean isVisible;

	public StraightBullet(BulletSize size, BulletColor col) {
		super(0,0,size,col);
		this.color = BulletColor.RED;
		this.size = BulletSize.MEDIUM;
		this.isVisible = false;
	}
	
	@Override
	public boolean collided() {
		// TODO Auto-generated method stub
		//if (Math.sqrt)
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		//explosion
		
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}

	public void shootStraight(float x, float y, BulletSize size,
			BulletColor color) {
		
	}

	
	
}
