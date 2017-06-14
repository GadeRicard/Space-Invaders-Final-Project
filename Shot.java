import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Actor
{
    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        checkCollision();
    }    
    
     /**
     * move causes the Shot object to move upwards.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called by the Shot class.
     */
    private void move()
    {
        setLocation(getX(), getY() - 6);
    }
    
    /**
     * checkCollision removes this object if it reaches the top edge of the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called by the Shot class.
     */
    private void checkCollision()
    {
        if( getY() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
