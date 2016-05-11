package komorebi.jenkins.states;

import org.lwjgl.input.Keyboard;

import komorebi.jenkins.engine.Difficulty;

public class Settings extends GameState {

	public int bombs;
	public int lives;
	public Difficulty difficulty;
	public SettingType selectedSetting;
	public boolean hasMusicEnabled = true, hasSFXEnabled = true;
	
	public void getInput() {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			next();
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			switch (selectedSetting) {
				case BOMBS: 
					if (!(this.bombs <=0)) {
						this.bombs--;
					}
					break;
				case LIVES:
					if (this.lives>0) {
						this.lives--;
					}
				case DIFFICULTY:
					if (this.difficulty==Difficulty.HARD) {
						this.difficulty=Difficulty.NORMAL;
					} else if (this.difficulty==Difficulty.NORMAL) {
						this.difficulty=Difficulty.EASY;
					}
					break;
				case MUSIC:
					if (!hasMusicEnabled) {
						hasMusicEnabled = true;
					}
					break;
				case SFX:
					if (!hasSFXEnabled) {
						hasSFXEnabled = true;
					}
				case QUIT:
					break;
			}
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			switch (selectedSetting) {
			case BOMBS: //increases bombs if there are less than 5
				if (this.bombs <5) {
					this.bombs++;
				}
				break;
			case LIVES:
				if (this.lives<5) {
					this.lives++;
				}
				break;
			case DIFFICULTY:
				if (this.difficulty==Difficulty.EASY) {
					this.difficulty=Difficulty.NORMAL;
				} else if (this.difficulty==Difficulty.NORMAL) {
					this.difficulty=Difficulty.HARD;
				}
				break;
			case MUSIC:
				if (this.hasMusicEnabled) {
					this.hasMusicEnabled = false;
				}
				break;
			case SFX:
				if (this.hasSFXEnabled) {
					this.hasSFXEnabled = false;
				}
				break;
			case QUIT:
				break;
			}
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) || Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if (this.selectedSetting==SettingType.QUIT) {
				GameState.switchState(State.MENU);
			}
		}
		
	}

	public void render() {
		
		
	}

	public void update() {
		
		
	}
	
	public void next() {
		if (this.selectedSetting==SettingType.BOMBS) {
			this.selectedSetting = SettingType.LIVES;
		} else if (this.selectedSetting==SettingType.LIVES) {
			this.selectedSetting = SettingType.DIFFICULTY;
		} else if (this.selectedSetting==SettingType.DIFFICULTY) {
			this.selectedSetting = SettingType.MUSIC;
		} else if (this.selectedSetting==SettingType.MUSIC) {
			this.selectedSetting = SettingType.SFX;
		} else if (this.selectedSetting==SettingType.SFX) {
			this.selectedSetting = SettingType.QUIT;
		} else if (this.selectedSetting==SettingType.QUIT) {
			this.selectedSetting = SettingType.BOMBS;
		}
		
	}

}
