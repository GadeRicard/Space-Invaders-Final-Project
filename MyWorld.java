import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * A (mostly) working replication of the video game "Space Invaders"
 * 
 * Author: Gade Ricard
 * Teacher: Mr.Hardman
 * Assignment: Final Assignment
 * Date Last Modified: June 13th
 */
public class MyWorld extends World
{
    //enemiesLeft is private because it will only be used within the MyWorld class
    private int enemiesLeft;
    String[] playerInitials = new String[10];
    int[] score = new int[10];
    
    /**
     * When an object of the class MyWorld is created, this method is called.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("Background.png");
        initialize();
        Enemy.started();
    }
    
    /**
     * initialize creates the objects in the game when the world is created.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is private because it will only be called a single time, only in this class.
     */
    private void initialize()
    {
        addObject(new Player(), getWidth() / 2, getHeight() - 20);
        addObject(new Enemy1(), 1 * (getWidth()/10), 60);
        addObject(new Enemy1(), 2 * (getWidth()/10), 60);
        addObject(new Enemy1(), 3 * (getWidth()/10), 60);
        addObject(new Enemy1(), 4 * (getWidth()/10), 60);
        addObject(new Enemy1(), 5 * (getWidth()/10), 60);
        addObject(new Enemy1(), 6 * (getWidth()/10), 60);
        addObject(new Enemy1(), 7 * (getWidth()/10), 60);
        addObject(new Enemy1(), 8 * (getWidth()/10), 60);
        addObject(new Enemy1(), 9 * (getWidth()/10), 60);
        
        addObject(new Enemy2(), 1 * (getWidth()/10), 100);
        addObject(new Enemy2(), 2 * (getWidth()/10), 100);
        addObject(new Enemy2(), 3 * (getWidth()/10), 100);
        addObject(new Enemy2(), 4 * (getWidth()/10), 100);
        addObject(new Enemy2(), 5 * (getWidth()/10), 100);
        addObject(new Enemy2(), 6 * (getWidth()/10), 100);
        addObject(new Enemy2(), 7 * (getWidth()/10), 100);
        addObject(new Enemy2(), 8 * (getWidth()/10), 100);
        addObject(new Enemy2(), 9 * (getWidth()/10), 100);
        
        addObject(new Enemy3(), 1 * (getWidth()/10), 140);
        addObject(new Enemy3(), 2 * (getWidth()/10), 140);
        addObject(new Enemy3(), 3 * (getWidth()/10), 140);
        addObject(new Enemy3(), 4 * (getWidth()/10), 140);
        addObject(new Enemy3(), 5 * (getWidth()/10), 140);
        addObject(new Enemy3(), 6 * (getWidth()/10), 140);
        addObject(new Enemy3(), 7 * (getWidth()/10), 140);
        addObject(new Enemy3(), 8 * (getWidth()/10), 140);
        addObject(new Enemy3(), 9 * (getWidth()/10), 140);
        
        addObject(new Enemy1(), 1 * (getWidth()/10), 180);
        addObject(new Enemy1(), 2 * (getWidth()/10), 180);
        addObject(new Enemy1(), 3 * (getWidth()/10), 180);
        addObject(new Enemy1(), 4 * (getWidth()/10), 180);
        addObject(new Enemy1(), 5 * (getWidth()/10), 180);
        addObject(new Enemy1(), 6 * (getWidth()/10), 180);
        addObject(new Enemy1(), 7 * (getWidth()/10), 180);
        addObject(new Enemy1(), 8 * (getWidth()/10), 180);
        addObject(new Enemy1(), 9 * (getWidth()/10), 180);
        
        addObject(new Enemy2(), 1 * (getWidth()/10), 220);
        addObject(new Enemy2(), 2 * (getWidth()/10), 220);
        addObject(new Enemy2(), 3 * (getWidth()/10), 220);
        addObject(new Enemy2(), 4 * (getWidth()/10), 220);
        addObject(new Enemy2(), 5 * (getWidth()/10), 220);
        addObject(new Enemy2(), 6 * (getWidth()/10), 220);
        addObject(new Enemy2(), 7 * (getWidth()/10), 220);
        addObject(new Enemy2(), 8 * (getWidth()/10), 220);
        addObject(new Enemy2(), 9 * (getWidth()/10), 220);
        
        addObject(new Enemy3(), 1 * (getWidth()/10), 260);
        addObject(new Enemy3(), 2 * (getWidth()/10), 260);
        addObject(new Enemy3(), 3 * (getWidth()/10), 260);
        addObject(new Enemy3(), 4 * (getWidth()/10), 260);
        addObject(new Enemy3(), 5 * (getWidth()/10), 260);
        addObject(new Enemy3(), 6 * (getWidth()/10), 260);
        addObject(new Enemy3(), 7 * (getWidth()/10), 260);
        addObject(new Enemy3(), 8 * (getWidth()/10), 260);
        addObject(new Enemy3(), 9 * (getWidth()/10), 260);
        
        playerInitials[0] = "WIN";
        playerInitials[1] = "BUT";
        playerInitials[2] = "HEY";
        playerInitials[3] = "CAT";
        playerInitials[4] = "ART";
        playerInitials[5] = "AFK";
        playerInitials[6] = "HEY";
        playerInitials[7] = "AFK";
        playerInitials[8] = "AFK";
        playerInitials[9] = "AFK";
        
        score[0] = 53;
        score[1] = 49;
        score[2] = 40;
        score[3] = 38;
        score[4] = 30;
        score[5] = 21;
        score[6] = 7;
        score[7] = 0;
        score[8] = 0;
        score[9] = 0;
    }
    
    /**
     * gameOver calculates the score obtained in this playthrough,
     * and creates, changes and displays the leaderboard when the game is completed.
     * 
     * @param There are no parameters.
     * @return Nothing is returned.
     * 
     * This method is public because it needs to be called by other classes outside of MyWorld,
     * such as the Player class and the Enemy class.
     */
    public void gameOver()
    {
        showText("Game Over!", 300, 50);
        
        if(Enemy.getNumEnemies() == 0)
        {
            enemiesLeft = 54;
            showText("Winner!", 300, 50);
        }
        else
        {
            enemiesLeft = 54 - Enemy.getNumEnemies();
            showText("Game Over!", 300, 50);
        }

        for(int i = 0; i < playerInitials.length; i++)
        {
            if( enemiesLeft > score[i] )
            {
                playerInitials[i] = "->" + JOptionPane.showInputDialog( null, "Enter your initials (3 Character max)" );
                score[i] = enemiesLeft;
                i = playerInitials.length + 1;
            }
        }
        
        showText("1. " + playerInitials[0] + " " + score[0] + "\n2. " + playerInitials[1] + " " + score[1] + "\n3. " + playerInitials[2] + " " + score[2] + "\n4. " + playerInitials[3] + " " + score[3] + "\n5. " + playerInitials[4] + " " + score[4] + "\n6. " + playerInitials[5] + " " + score[5] + "\n7. " + playerInitials[6] + " " + score[6] + "\n8. " + playerInitials[7] + " " + score[7] + "\n9. " + playerInitials[8] + " " + score[8] + "\n10. " + playerInitials[9] + " " + score[9], 300, 250);
        
        Greenfoot.stop();
    }
}
