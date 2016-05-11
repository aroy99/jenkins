package komorebi.jenkins.states;

import org.lwjgl.input.Keyboard;

public class Pause extends GameState {

	public boolean wantsToContinue = true;
	
	@Override
	public void getInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			wantsToContinue = !wantsToContinue;
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
