/*
 * Main.java	Feb 13, 2016
 */

package komorebi.jenkins.engine;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import komorebi.jenkins.engine.GameHandler;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.openal.SoundStore;

/**
 * Initializes everything and uses the game handler to start the game
 * 
 * @author Aaron Roy 
 * @version 0.0.2.0
 * 
 */
public class Main {
	
	private static int scale;
	private static BufferedReader read;
	private static GameHandler gh;
	
	/**
	 * Reads settings file and gets the size, then starts the game
	 * 
	 * @param args command prompt arguments that are currently unused
	 */
	public static void main(String[] args){
		try {
			read = new BufferedReader(new FileReader(
			                          new File("res/settings.txt")));
			String s;
			
			while ((s = read.readLine()) != null) {
				if(s.charAt(0)=='#')continue;
				if(scale == 0)scale = Integer.parseInt(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			scale = 1;
		}
				
		initDisplay();
		initGL();
		
		initGame();
		gameLoop();
		cleanUp();
	}
	
	
    /** 
     *  Initializes the Display, using the Display Class, properly Scaling it
     */
	public static void initDisplay(){
		//create display
				try {
					Display.setDisplayMode(new DisplayMode(
					                             482*scale,300*scale));
					Display.setTitle("Jenkins!");
					Display.create();
					Display.setVSyncEnabled(true);
					
				} catch (LWJGLException e) {
					e.printStackTrace();
				}
	}

    /**
     *  Creates a new game and initializes the audio
     *  @see GameHandler
     */
	private static void initGame(){
		 gh = new GameHandler();
	}
	
	/**
	 *  Uses the gamehandler to getInput from all of its objects
	 */
	private static void getInput(){
		gh.getInput();
	}
	
	private static void update(){
		gh.update();
	}
	
	
	private static void render(){
		glClear(GL_COLOR_BUFFER_BIT); //clears the matrix with black
		glLoadIdentity();
		gh.render();
		
		Display.update();			  //updates the display with the changes
		Display.sync(60);			  //makes up for lost time
		
	}
	
	
    /**
	 *  Goes through the game loop, starting the music once
     */
	private static void gameLoop(){
		
		while(!Display.isCloseRequested()){
			getInput();
			update();
			render();
			SoundStore.get().poll(0);

			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				break;
			}
			
		}
	}
	
	/**
     *  Currently Enabled:<br>
     *  -Textures<br>
     *  -Transparency
     *  <p>
     *  Size: 482 x 300
     */
	private static void initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();				//resets the Matrix
		glOrtho(0,482,0,300,-1,1);		//creates a 3D space
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);		//enables Textures
		glEnable (GL_BLEND);
		                                //Enables transparency
		glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);


		glClearColor(0,0,0,1);			//sets the clearing color to black
		
		glDisable(GL_DEPTH_TEST);		//kills off the third dimension
	}

    /**
	 *  Destroys the display and keyboard, closing the window
     */
	private static void cleanUp(){
		Display.destroy();
		AL.destroy();
	}
	
	
}
