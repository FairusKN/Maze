import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startbutton extends Actor
{
    private GreenfootImage button;
    private GreenfootImage button_hover;
    
    public Startbutton(){
        button = new GreenfootImage("lobi/button_hover.png");
        button_hover = new GreenfootImage("lobi/button.png");
        setImage(button);
    }
    
    public void act()
    {
        if(Greenfoot.mouseMoved(this)){
            setImage(button);
        }
        
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(button_hover);
        }
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MazeWorld());
            Greenfoot.playSound("ingame.mp3");
        }
    }
}
