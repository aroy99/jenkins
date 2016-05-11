package komorebi.jenkins.entity;

import java.util.ArrayList;

public abstract class Bullets extends Entity{

    public BulletSize size;
    public BulletColor color;
    public static int bulletCount;

    public enum BulletSize {
        SMALL,
        MEDIUM,
        LARGE,
        SUPERSIZEME,
        PLAYER;
    }

    public enum BulletColor {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        VIOLET;
    }


    /**
     * Creates a Bullet Object with a set radius and center
     */
    public Bullets(float x, float y, BulletSize size, BulletColor color){
        super(x, y, size == BulletSize.SMALL       ? 4 :
                    size == BulletSize.MEDIUM      ? 8 :
                    size == BulletSize.LARGE       ? 16 :
                    size == BulletSize.SUPERSIZEME ? 32:4,

                    size == BulletSize.SMALL       ? 4 :
                    size == BulletSize.MEDIUM      ? 8 :
                    size == BulletSize.LARGE       ? 16 :
                    size == BulletSize.SUPERSIZEME ? 32:7);
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
}