import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_Shot extends Actor
{
    /**
     * Act - do whatever the Enemy_Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        checkCollision();
    }    
    
    /**
     * move causes the Enemy_Shot object to move downwards.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called by the Enemy_Shot class.
     */
    private void move()
    {
        setLocation(getX(), getY() + 3);
    }
    
    /**
     * checkCollision removes this object if it reaches the bottom edge of the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called by the Enemy_Shot class.
     */
    private void checkCollision()
    {
        if( getY() >= 399)
        {
            getWorld().removeObject(this);
        }
    }
}
