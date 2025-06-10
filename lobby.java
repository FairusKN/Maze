import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lobby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lobby extends World
{

    /**
     * Constructor for objects of class lobby.
     * 
     */
    public lobby()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(70, 40, 15);

        teks icon = new teks("maze.png", 400, 200); // hanya gambar
        addObject(icon, getWidth() / 2, getHeight() / 4); // tampilkan di tengah
        
        setBackground("lobi.jpg");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Startbutton startbutton = new Startbutton();
        addObject(startbutton,33,30);
        startbutton.setLocation(36,30);
    }
}
