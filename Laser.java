import greenfoot.*;

public class Laser extends Actor {
    private GreenfootImage[] laserFrames = new GreenfootImage[13];
    private int frameIndex = 0;
    private int animationCounter = 0;
    private int animationSpeed = 4; // smaller = faster animation

    private boolean isOn = true;
    private int delayCounter = 0;
    private int delayTime = 120; // time laser stays in one state

    public Laser() {
        for (int i = 0; i < 13; i++) {
            GreenfootImage img = new GreenfootImage("laser/sprite_" + String.format("%02d", i) + ".png");
            img.scale(64, 64); // You can change 128 to any size you want
            laserFrames[i] = img;
        }
        setImage(laserFrames[0]);
    }


    public void act() {
        handleDelay();
        animateLaser();
        checkCollision();
    }

    private void handleDelay() {
        delayCounter++;
        if (delayCounter >= delayTime) {
            isOn = !isOn;
            delayCounter = 0;
            frameIndex = isOn ? 0 : laserFrames.length - 1; // reset frame index
        }
    }

    private void animateLaser() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            animationCounter = 0;

            if (isOn && frameIndex < laserFrames.length - 1) {
                frameIndex++;
            } else if (!isOn && frameIndex > 0) {
                frameIndex--;
            }

            setImage(laserFrames[frameIndex]);
        }
    }

    private void checkCollision() {
        if (isOn && frameIndex == laserFrames.length - 1) {
            Actor player = getOneIntersectingObject(Player.class);
            if (player != null) {
                player.setLocation(100, 300);
            }
        }
    }
}
