/*
 * Bullets.java           Feb 13, 2016
 */

package komorebi.jenkins.entity;

import java.util.ArrayList;

import komorebi.jenkins.engine.Draw;


/**
 * A bullet fired by an enemy
 * 
 * @author Aaron Roy
 * @version 0.0.2.0
 * 
 */
public abstract class Bullets extends Entity{

    protected BulletSize size;
    protected BulletColor color;
    protected static int bulletCount;

    public enum BulletSize {
        SMALL,
        MEDIUM,
        LARGE,
        SUPERSIZEME,
    }

    public enum BulletColor {
        RED(0),
        ORANGE(1),
        YELLOW(2),
        GREEN(3),
        BLUE(4),
        VIOLET(5);
        
        int num;
        
        BulletColor(int n){num = n;}
        
        public int getNum(){return num;}
    }


    /**
     * Creates a Bullet Object with a set radius and center
     */
    public Bullets(float x, float y, BulletSize size, BulletColor color){
        super(x, y, size == BulletSize.SMALL       ? 4 :
                    size == BulletSize.MEDIUM      ? 8 :
                    size == BulletSize.LARGE       ? 16 :
                    size == BulletSize.SUPERSIZEME ? 32:0,

                    size == BulletSize.SMALL       ? 4 :
                    size == BulletSize.MEDIUM      ? 8 :
                    size == BulletSize.LARGE       ? 16 :
                    size == BulletSize.SUPERSIZEME ? 32:0);
        this.color = color;
        this.size = size;
        System.out.println(bulletCount);
        bulletCount++;

    }

    /**
     * Determines if hitbox is in contact with another
     */
    public abstract boolean collided();

    /**
     * Kills the Entity in the ArrayList if it falls off the screen
     */
    public void kill(ArrayList<Entity> eList)
    {
        eList.remove(this);
    }

    /**
     * This allows the program to determine the bullet's hitbox radius 
     */
    public float getRadius(){
        return radius;
    }
    
    /**
     *  Renders the correct bullet size and color 
     *  depending on instance variables
     */
    public void render(){
        int tX, tY, s; //Texture X and Y, and size
        
        switch(size){
        case SMALL:
            tY = 32;
            s = 4; 
            break;
        case MEDIUM:
            tY = 37;
            s = 8;
            break;
        case LARGE:
            tY = 48;
            s = 16;
            break;
        case SUPERSIZEME:
            tY = 67;
            s = 29;
            break;
        default:
            tY = 0;
            s = 0;
            break;
        }
        
        tX = s*color.getNum();
        
        Draw.rect(x, y, s, s, tX, tY, tX+s, tY+s, 0);

    }

}