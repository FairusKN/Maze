import greenfoot.*;

public class LuckyBox extends Actor {
    private int bonusTime = 5; // Extra time if lucky
    private int animationFrame = 0; // Track animation frame
    private boolean isOpening = false; // Track if animation is playing
    private GreenfootImage[] chestFrames; // Store animation frames

    public LuckyBox() {
        // Load chest images (Assuming images are in "Chests" folder)
        chestFrames = new GreenfootImage[8]; // 8 images (0 to 7)
        for (int i = 0; i < 8; i++) {
            chestFrames[i] = new GreenfootImage("Chests/treasure_" + i + ".png");
        }
        
        setImage(chestFrames[0]); // Set default closed chest
    }

    public void act() {
        if (!isOpening) {
            checkPlayerTouch();
        } else {
            playAnimation();
        }
    }

    private void checkPlayerTouch() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            isOpening = true; // Start animation
        }
    }

    private void playAnimation() {
        if (animationFrame < chestFrames.length) {
            setImage(chestFrames[animationFrame]);
            animationFrame++;
        } else {
            applyEffect(); // After animation, apply the lucky/unlucky effect
            getWorld().removeObject(this); // Remove chest after opening
        }
    }

    private void applyEffect() {
        int randomOutcome = Greenfoot.getRandomNumber(3); // 0 or 1
        Player player = (Player) getWorld().getObjects(Player.class).get(0); 

        if (randomOutcome == 0) {
            // Bad luck: Send player back to their original position
            player.setLocation(player.getSpawnX(), player.getSpawnY()); // Ensure player has a spawn tracking system
            getWorld().showText("Unlucky! Back to Start!", getWorld().getWidth() / 2, 50);
        } else if (randomOutcome==1){
            triggerJumpscare();
        }else {
            // Good luck: Add bonus time
            Timer timer = getWorld().getObjects(Timer.class).get(0);
            timer.addTime(bonusTime);
            getWorld().showText("Lucky! +5 Seconds!", getWorld().getWidth() / 2, 50);
        }
    }
    
    private void triggerJumpscare()
    {
        World world = getWorld(); // Save reference
        GreenfootImage jumpscare = new GreenfootImage("jumpscare.jpg");
    
        // Scale the image to match the world size
        jumpscare.scale(world.getWidth(), world.getHeight());
    
        // Set the image as the world's background
        world.setBackground(jumpscare);
        
        // Play scream sound
        Greenfoot.playSound("horror-scream.mp3");
        Greenfoot.playSound("horror-theme.wav");
    }
}
