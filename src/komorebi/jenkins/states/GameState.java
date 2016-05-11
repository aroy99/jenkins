package komorebi.jenkins.states;

import komorebi.jenkins.engine.GameHandler;

public abstract class GameState {
	public static void switchState(State state) {
		GameHandler.state = state;
	}
	public abstract void getInput();
	public abstract void render();
	public abstract void update();
	
}
