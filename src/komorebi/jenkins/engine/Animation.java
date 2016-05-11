package komorebi.jenkins.engine;


public class Animation {
	
	private int frames;
	private int time;
	private int counter;
	private int[] texx;
	private int[] texy;
	private int currFrame;
	private int cAddFrame;
	private float sx,sy;
	private int texID;
	
	/**
	 * Creates a playable animation
	 * 
	 * @param f - Max number of frames
	 * @param t - Time till next frame in frames
	 * @param x - x location for the animation
	 * @param y - y location for the animation
	 * @param sx - size x for the animation *used to calculate other tex coordinates too
	 * @param sy - size y for the animation *used to calculate other tex coordinates too
	 * @param ID - The Texture ID
	 */
	public Animation(int f, int t, float sx, float sy, int ID){
		frames = f;
		texx = new int[frames];
		texy = new int[frames];
		time = t;
		texID = ID;
		this.sx = sx;
		this.sy = sy;
	}
	
	/**
	 * Adds a new frame
	 * 
	 * @param tx - Texture X
	 * @param ty - Texture Y
	 */
	public void add(int tx, int ty){
		texx[cAddFrame] = tx;
		texy[cAddFrame] = ty;
		cAddFrame++;
	}
	
	public void play(float x, float y){
		Draw.drawRect(x, y, sx, sy, texx[currFrame], texy[currFrame], texx[currFrame]+(int)sx, texy[currFrame]+(int)sy, texID);
		
		counter++;
		if(counter>time){
			counter = 0;
			currFrame++;
			if (currFrame>frames-1)currFrame = 0;
		}
	}
}
