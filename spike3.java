import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spike3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spike3 extends Spikes
{
    public void act()
    {
        // Cek jika Spike bersentuhan dengan pemain
        Actor player = getOneIntersectingObject(Player.class);
        
        // Jika pemain menyentuh spike, panggil metode untuk mengembalikan pemain
        if (player != null)
        {
            // Panggil metode untuk mengembalikan pemain ke posisi awal
            resetPlayerPosition(player);
        }
    }

    private void resetPlayerPosition(Actor player)
    {
        // Tentukan posisi awal pemain (misalnya, di koordinat x=100, y=300)
        player.setLocation(100, 300);
    }
}
