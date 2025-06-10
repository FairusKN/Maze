import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends World
{

    /**
     * Constructor for objects of class Win.
     * 
     */
    
    private GreenfootImage bg; 
    public Win()
    {    
        super(70, 40, 15);

        bg = new GreenfootImage("win.jpg");
            bg.scale(getWidth() * getCellSize(), getHeight() * getCellSize());
        setBackground(bg);
    }
}
