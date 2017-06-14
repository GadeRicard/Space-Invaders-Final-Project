import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    //  numOfEnemies, movingLeft, moveDown, and switchCounter are static because 
    //they must synchronize with all instances of the Enemy class and all Subclasses.
    //  All of these instance variables are private instead of protected because all of the subclasses
    //of Enemy use the same code as Enemy, and so they don't need to be accessed by the subclasses.
    private static int numOfEnemies;
    private static boolean movingLeft = false;
    private static boolean moveDown;
    private static int switchCounter = 2000;
    private int movementDelay = 0;
    
    /**
     * When objects of the Enemy class or a subclass of Enemy is created,
     * this method is called.
     */
    public Enemy()
    {
        getImage().scale(32, 32);
    }
    
    /**
     * started ensures that the Enemy instance variables are the correct
     * value when the program is initialized.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is public because it must be called by the MyWorld class when the 
     * World is being created.
     * This method is static because it references and alters static variables.
     */
    public static void started()
    {
        numOfEnemies = 54;
        switchCounter = 2000;
        movingLeft = false;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fire();
        movement();
        checkCollision();
    }    
    
    /**
     * checkCollision checks if this object has reached the edge of the world,
     * and changes the direction the Enemy objects move and moves them down.
     * It also checks if this object is touching a Shot object, and removes this object
     * and the Shot object, and calculates how many Enemy objects are left.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private instead of protected because this code is used by the subclasses of
     * the Enemy class directly, instead of being called from within the subclasses.
     */
    private void checkCollision()
    {
        List<Enemy> enemies = getWorld().getObjects(Enemy.class);
        numOfEnemies = enemies.size();
        if(isAtEdge() == true)
        {
            if(switchCounter >= 2000)
            {
                movingLeft = !movingLeft;
                moveDown();
                switchCounter = 0;
            }
        }
        
        if(numOfEnemies <= 5)
        {
            switchCounter = switchCounter + 100;
        }
        else
        {
            switchCounter = switchCounter + 2;
        }
        
        if(getOneIntersectingObject(Shot.class) != null)
        {
            getWorld().removeObject(getOneIntersectingObject(Shot.class));
            numOfEnemies--;
            getWorld().removeObject(this);
        }
    }
    
    /**
     * movement controls the horizontal movement of the Enemy objects,
     * the speed of movement is determined by how many Enemy objects exist in the world.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private instead of protected because this code is used by the subclasses of
     * the Enemy class directly, instead of being called from within the subclasses.
     */
    private void movement()
    {
        if(movementDelay >= numOfEnemies / 4)
        {
            if(movingLeft == true)
            {
                move(-2);
                movementDelay = 0;
            }
            else
            {
                move(2);
                movementDelay = 0;
            }
        }
        movementDelay++;
    }
    
    /**
     * moveDown moves every Enemy object down 32 pixels when called
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private instead of protected because this code is used by the subclasses of
     * the Enemy class directly, instead of being called from within the subclasses.
     */
    private void moveDown()
    {
        List<Enemy> enemies = getWorld().getObjects(Enemy.class);
        
        for(int i = 0; i < enemies.size(); i++)
            {
                enemies.get(i).setLocation(enemies.get(i).getX(), enemies.get(i).getY() + 32);
            }
    }
    
    /**
     * fire creates an Enemy_Shot object if both there isn't an Enemy_Shot in the world already,
     * and if a random number between 0 and 99 is 0.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private instead of protected because this code is used by the subclasses of
     * the Enemy class directly, instead of being called from within the subclasses.
     */
    private void fire()
    {
        if(getWorld().getObjects(Enemy_Shot.class).size() <= 0 && Greenfoot.getRandomNumber(100) == 0)
        {
            getWorld().addObject(new Enemy_Shot(), getX(), getY() + 20);
        }
    }
    
    /**
     * getNumEnemies is a getter method that returns the variable numOfEnemies when called.
     * 
     * @param There are no parameters.
     * @return returns the numOfEnemies variable.
     * 
     *  This method is public because it is called by other classes to transfer the numOfEnemies
     * variable, as with all getter methods.
     *  This method is static because it references and alters a static variable.
     */
    public static int getNumEnemies()
    {
        return numOfEnemies;
    }
    
    /**
     * setNumEnemies is a setter method that changes numOfEnemies to the parameter.
     * 
     * @param int newNumEnemies is the value that numOfEnemies will be changed to.
     * @return Nothing is returned.
     * 
     *  This method is public because it is called by other classes to change a private instance variable,
     * as with all setter methods.
     *  This method is static because it references and alters a static variable.
     */
    public static void setNumEnemies(int newNumEnemies)
    {
        numOfEnemies = newNumEnemies;
    }
}
