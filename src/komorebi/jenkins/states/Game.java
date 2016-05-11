package komorebi.jenkins.states;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import komorebi.jenkins.engine.AudioHandler;
import komorebi.jenkins.engine.TextHandler;
import komorebi.jenkins.entity.Agent;
import komorebi.jenkins.entity.AimedBullet;
import komorebi.jenkins.entity.Bullets;
import komorebi.jenkins.entity.Enemy;
import komorebi.jenkins.entity.Player;

public class Game extends GameState{

    public static Player play;
    public static ArrayList<Bullets> bullets;
    public static ArrayList<Enemy> enemies;
    TextHandler text;

    public Game(){
        play = new Player();
        bullets = new ArrayList<Bullets>();
        enemies = new ArrayList<Enemy>();
        text = new TextHandler(0,96);
        text.write("THE QUICK BROWN FOX JUMPED OVER THE/LAZY DOG!?,.\'\"1234567890");
        Enemy.loadBullets();
        AudioHandler.init();

        enemies.add(new Agent(0, -1,10, Bullets.BulletColor.RED, 250, Bullets.BulletSize.SUPERSIZEME));
    }


    @Override
    public void getInput() {
        play.getInput();
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            enemies.add(new Agent(0, -1,10, Bullets.BulletColor.RED, 250, Bullets.BulletSize.SUPERSIZEME));
        }

    }

    @Override
    public void render() {
        play.render();
        for(Bullets b:bullets){
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
        for(Bullets b:bullets){
            b.update();

        }
        AudioHandler.playMusic();
        for (final Iterator<Bullets> iterator = bullets.iterator(); iterator.hasNext(); ) {
            Bullets b = iterator.next();
            if (b.getY()>300) {
                iterator.remove();
                b=null;
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

    public static ArrayList<Bullets> getBullets(){
        return bullets;
    }
}
