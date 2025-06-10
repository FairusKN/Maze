import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Movers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movers extends Actor
{
    /**
     * Act - do whatever the Movers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void moveAround() {
        int speed = 1; // Keep speed low for precise movement
    
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            setRotation(0);
            if (canMove(speed)) {
                move(speed);
            }
        }
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            setRotation(180);
            if (canMove(speed)) {
                move(speed);
            }
        }
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            setRotation(270);
            if (canMove(speed)) {
                move(speed);
            }
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            setRotation(90);
            if (canMove(speed)) {
                move(speed);
            }
        }
    }
    
    public boolean canMove(int speed) {
        // Simulate moving forward and check for collisions
        move(speed);
        boolean touching = isTouching(MazeBlock.class);
        move(-speed); // Move back to original position
        return !touching; // Return true if no collision
    }

}
