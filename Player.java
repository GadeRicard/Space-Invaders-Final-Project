import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkCollision();
    }    
    
    /**
     * checkKeys checks which keys are being pressed by the player, and moves the 
     * Player object or calls the fire method.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private because it will only be used within the Player class.
     */
    private void checkKeys()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            fire();
        }
        
        if(Greenfoot.isKeyDown("left") && getX() >= 12)
        {
            setLocation(getX() - 2, getY());
        }
        
        if(Greenfoot.isKeyDown("right") && getX() <= 588)
        {
            setLocation(getX() + 2, getY());
        }
    }
    
    /**
     * fire creates a Shot object if there is not already one in existance.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called from the Player class.
     */
    private void fire()
    {
        if(getWorld().getObjects(Shot.class).size() <= 0)
        {
            getWorld().addObject(new Shot(), getX(), getY() - 20);
        }
    }
    
    /**
     * checkCollision checks if the Player object is touching an Enemy object or an
     * Enemy_Shot object, or if there are no Enemy objects in the world, and calls the 
     * gameOver method in MyWorld if any of these conditions are true.
     * 
     * @param There are no parameters
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called from the Player class.
     */
    private void checkCollision()
    {
        MyWorld w = (MyWorld)getWorld();
        if(isTouching(Enemy.class) == true || isTouching(Enemy_Shot.class) == true)
        {
            w.gameOver();
        }
        
        if(Enemy.getNumEnemies() == 0)
        {
            w.gameOver();
        }
    }
}
