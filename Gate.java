import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gate extends Actor
{
    /**
     * Act - do whatever the Gate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Check if the player is touching the gate
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null)
        {
            // If the player has the key, open the gate
            if (player.hasKey())
            {
                openGate();
            }
        }
    }
    
    public void openGate()
    {
        World currentWorld = getWorld();
        
        if(currentWorld instanceof MazeWorld){
            Greenfoot.setWorld(new Level2());    
        }else if(currentWorld instanceof Level2){
            Greenfoot.setWorld(new Level3());
        }else if(currentWorld instanceof Level3){
            Greenfoot.setWorld(new Level4());
        }else if(currentWorld instanceof Level4) {
            Greenfoot.setWorld(new Level5());
        }else if(currentWorld instanceof Level5) {
            
            //getWorld().showText("Congratulation, You win the Game", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            //GreenfootImage message = new GreenfootImage("Congratulations, You Win the Game!", 36, Color.YELLOW, new Color(0, 0, 0, 160));
            //getWorld().getBackground().drawImage(
            //    message,
            //    getWorld().getWidth()/2 - message.getWidth()/2,
            //    getWorld().getHeight()/2 - message.getHeight()/2
            //);
            //getWorld().removeObject(this);
            
            Greenfoot.setWorld(new Win());
            Greenfoot.playSound("win.mp3");
            Greenfoot.stop();
        }
    }
}
