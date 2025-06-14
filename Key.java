import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Actor
{
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null)
        {
            // Notify the player that they have collected the key
            player.collectKey();
            
            // Remove the key from the world
            getWorld().removeObject(this);
        }
    }
}
