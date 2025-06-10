import greenfoot.*;

public class PlayerTag extends Movers {
    private Player player;

    public PlayerTag(Player player) {
        this.player = player;
        GreenfootImage label = new GreenfootImage("PLAYER\n↓", 20, Color.WHITE, new Color(0,0,0,0));
        setImage(label);
    }

    public void act() {
        if (player == null || player.getWorld() == null) {
            World world = getWorld();
            if (world != null) {
                world.removeObject(this);
            }
            return;
        }
    
        if (getWorld() != player.getWorld()) {
            World world = getWorld();
            if (world != null) {
                world.removeObject(this);
            }
            return;
        }
    
        setLocation(player.getX(), player.getY() - 50);
    }

}
