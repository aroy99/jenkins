package komorebi.jenkins.engine;

import komorebi.jenkins.states.Boss;
import komorebi.jenkins.states.Credits;
import komorebi.jenkins.states.Death;
import komorebi.jenkins.states.Dialogue;
import komorebi.jenkins.states.Game;
import komorebi.jenkins.states.GameState;
import komorebi.jenkins.states.Menu;
import komorebi.jenkins.states.Pause;
import komorebi.jenkins.states.Settings;
import komorebi.jenkins.states.State;


public class GameHandler {

	public static State state;
	GameState gameState;
	Menu menu = new Menu();
	Settings settings = new Settings();
	Game game = new Game();
	Pause pause = new Pause();
	Death death = new Death();
	Boss boss = new Boss();
	Credits credits = new Credits();
	Dialogue dialogue = new Dialogue();

	
	int maxContinues;
	int maxBombs;
	static Difficulty difficulty = Difficulty.HARD;
	
	public GameHandler() {
		state = State.MENU;
	}
	
	public void render() {
		switch (state) {
			case MENU:
				menu.render();
				break;
			case SETTINGS:
				settings.render();
			case GAME:
				game.render();
				break;
			case PAUSE:
				pause.render();
				break;
			case DEATH:
				death.render();
				break;
			case BOSS:
				boss.render();
				break;
			case CREDITS:
				credits.render();
				break;
			case DIALOGUE:
				dialogue.render();
				break;
			default:
				break;
		}
	}

	public void getInput() {
		switch (state) {
		case MENU:
			menu.getInput();
			break;
		case SETTINGS:
			settings.getInput();
		case GAME:
			game.getInput();
			break;
		case PAUSE:
			pause.getInput();
			break;
		case DEATH:
			death.getInput();
			break;
		case BOSS:
			boss.getInput();
			break;
		case CREDITS:
			credits.getInput();
			break;
		case DIALOGUE:
			dialogue.getInput();
			break;
        case LOAD_SCREEN:
            break;
        default:
            break;
		}
		
	}

	public void update() {
		switch (state) {
		case MENU:
			menu.update();
			break;
		case SETTINGS:
			settings.update();
		case GAME:
			game.update();
			break;
		case PAUSE:
			pause.update();
			break;
		case DEATH:
			death.update();
			break;
		case BOSS:
			boss.update();
			break;
		case CREDITS:
			credits.update();
			break;
		case DIALOGUE:
			dialogue.update();
			break;
        case LOAD_SCREEN:
            break;
        default:
            break;
		}		
	}
	
	public static Difficulty getDifficulty(){
		return difficulty;
	}
}