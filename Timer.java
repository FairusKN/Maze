import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Timer extends Actor {
    private int timeRemaining;
    private GreenfootImage timeImage;
    private int frameCounter;

    private boolean gameOver = false;
    private int delayFrames = 0; // Counts frames after game over

    public Timer(int timeLimit) {
        timeRemaining = timeLimit;
        timeImage = new GreenfootImage(100, 30);
        setImage(timeImage);
        updateImage();
        frameCounter = 0;
    }

    public void act() {
        if (!gameOver) {
            frameCounter++;
    
            if (frameCounter % 60 == 0 && timeRemaining > 0) {
                timeRemaining--; // your test shortcut
                updateImage();
    
                if (timeRemaining <= 0) {
                    gameOver = true;
                    getWorld().showText("GAME OVER", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                }
            }
        } else {
            delayFrames++;
            getWorld().showText("GAME OVER\nBack to lobby in " + (3 - delayFrames / 60), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    
            if (delayFrames >= 180) {
                getWorld().showText("", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                Greenfoot.setWorld(new lobby());
            }
        }
    }


    private void updateImage() {
        timeImage.clear();
        timeImage.setColor(Color.WHITE);
        timeImage.drawString("Time: " + timeRemaining, 10, 20);
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void addTime(int extraTime) {
        timeRemaining += extraTime;
        updateImage();
    }
}
