package komorebi.jenkins.engine;


import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class AudioHandler {
	
	private static Audio music;
	private static boolean loopStarted;
	private static boolean musicStarted;
	
	public static void init(){
        try {
        	music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/Jenkins! Theme.ogg"));
        	
	        System.out.println("Initialized music (hopefully)");
		} catch (Exception e) {
			System.out.println("RIP MUSIC");
			e.printStackTrace();
		}

	}
	
	
	public static void play(String key){
	}
	
	public static void playMusic(){
		if(!musicStarted){
			//music.playAsSoundEffect(1.0f, 1.0f, false);
			musicStarted = true;
		}	
	}


	/*public static void stop() {
		if(loopStarted){
			resPos = loop.getPosition();
			loop.stop();
			loopStarted = false;
		}
		else if(introStarted){
			resPos = intro.getPosition();
			intro.stop();
			introStarted = false;
		}
	}


	public static void resumeMusic() {
		if(!loopStarted){
			loop.playAsSoundEffect(1.0f,1.0f,true);
			loop.setPosition(resPos);
			loopStarted = true;
		}
	}*/
}
