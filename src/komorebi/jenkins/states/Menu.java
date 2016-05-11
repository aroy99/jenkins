package komorebi.jenkins.states;

import komorebi.jenkins.engine.Draw;

import org.lwjgl.input.Keyboard;

public class Menu extends GameState {

	public MenuItem selectedMenuItem;
	boolean wasDownPressed;
	private boolean downPressed;
	
	public Menu() {
		this.selectedMenuItem = MenuItem.GAME;
	}

	public void getInput() {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) || Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if (this.selectedMenuItem == MenuItem.GAME) {
				GameState.switchState(State.GAME);
			} else if (this.selectedMenuItem == MenuItem.SETTINGS) {
				GameState.switchState(State.SETTINGS);
			} else if (this.selectedMenuItem == MenuItem.CREDITS) {
				GameState.switchState(State.CREDITS);
			}
		}
		wasDownPressed = downPressed;
		downPressed = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
	}


	public void render() {
		Draw.drawRect(0, 0, 482, 320, 0, 0, 482, 320, 1);
		
	}


	public void update() {
		if (downPressed && !wasDownPressed) {
			next();
		}		
	}
	
	
	//changes arrow to the next menu item on screen
	public void next() { 
		if (this.selectedMenuItem == MenuItem.GAME) {
			this.selectedMenuItem = MenuItem.SETTINGS;
			System.out.println("Settings");
		} else if (this.selectedMenuItem == MenuItem.SETTINGS) {
			this.selectedMenuItem = MenuItem.CREDITS;
			System.out.println("Credits");
		} else if (this.selectedMenuItem == MenuItem.CREDITS) {
			this.selectedMenuItem = MenuItem.GAME;
			System.out.println("Game");
		}
	}

}
