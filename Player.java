import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Movers
{
    private int spawnX, spawnY;
    
    public Player(){
        
        if (getWorld() != null) {
            spawnX = getX();
            spawnY = getY();
        }
        
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
    }
    
    @Override
    protected void addedToWorld(World world) {
        spawnX = getX();
        spawnY = getY();
        
        //world.addObject(new PlayerTag(this), getX(), getY());
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
    
    private boolean hasKey = false;
    
    public void act()
    {
        moveAround();
        
        Gate gate = (Gate) getOneIntersectingObject(Gate.class);
        if (gate != null)
        {
            // If the player has the key, proceed to the next level
            if (hasKey)
            {
                gate.openGate();  // Call the gate's openGate method
            }
        }
    }
    
    public void collectKey()
    {
        hasKey = true;  // Set the flag to indicate the player has the key
    }

    // Optional: Method to check if the player has the key
    public boolean hasKey()
    {
        return hasKey;
    }
}
