/*
 * Game.java           Feb 13, 2016
 */

package komorebi.jenkins.states;

import java.util.ArrayList;
import java.util.Iterator;

import komorebi.jenkins.engine.AudioHandler;
import komorebi.jenkins.engine.TextHandler;
import komorebi.jenkins.entity.Agent;
import komorebi.jenkins.entity.AimedBullet;
import komorebi.jenkins.entity.Bullets;
import komorebi.jenkins.entity.Enemy;
import komorebi.jenkins.entity.Player;
import komorebi.jenkins.entity.PlayerBullet;

import org.lwjgl.input.Keyboard;

/**
 * The Game State, contains all enemies and bullets
 * 
 * @author Aaron Roy
 * @version 0.0.2.0
 * 
 */
public class Game extends GameState{

    public static Player play;
    public static ArrayList<PlayerBullet> bullets;
    public static ArrayList<Enemy> enemies;
    TextHandler text;
    
    public boolean hasSummoned = true;

    public Game(){
        play = new Player();
        bullets = new ArrayList<PlayerBullet>();
        enemies = new ArrayList<Enemy>();
        text = new TextHandler(0,96);
        text.write("WHAT'S  UP,  CHUMP?   YOU  WANT  TO/"
                  +"TUSSLE?  OR DO  YOU WANT  A KNUCKLE/"
                  +"SANDWICH? I CAN GO SUPER SAIYAN, SO/"
                  +"WATCH  YOUR  STEP OR YOU  WILL  GET/"
                  +"PUMMELED TO DEATH YOU LITTLE SCRUB!/");
        Enemy.loadBullets();
        AudioHandler.init();

        enemies.add(new Agent(0, -1,10, Bullets.BulletColor.YELLOW, 250, Bullets.BulletSize.MEDIUM));
    }


    @Override
    public void getInput() {
        play.getInput();
        if(Keyboard.isKeyDown(Keyboard.KEY_A) && !hasSummoned){
            enemies.add(new Agent(0, -1,10, Bullets.BulletColor.BLUE, 250, Bullets.BulletSize.LARGE));
            hasSummoned = true;
        }else hasSummoned = false;

    }

    @Override
    public void render() {
        play.render();
        for(PlayerBullet b:bullets){
            b.render();
        }
        for(Enemy e: enemies){
            e.render();
        }
        for(AimedBullet a: Enemy.aimedBullets ){
            if(a.isVisible){
                a.render();
            }
        }
        text.render();
    }

    @Override
    public void update() {
        play.update();
        for(PlayerBullet b:bullets){
            b.update();

        }
        AudioHandler.playMusic();
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet b = bullets.get(i);
            if (b.getY()>300) {
                bullets.remove(i);
                i--;
            }
        }
        for(AimedBullet a: Enemy.aimedBullets ){
            if(a.isVisible){
                a.update();
            }
        }
        for(Enemy e : enemies){
            e.update();
        }

    }

    public static Player getPlayer(){
        return play;
    }

    public static ArrayList<PlayerBullet> getBullets(){
        return bullets;
    }
}
