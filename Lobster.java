import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lobster extends Acctor {
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 3;
    public void act() {
      // super.act();
      seek(Crab.class);
      move(speed);
      if (removeTouchingClass(Crab.class)) {
        Greenfoot.playSound("ded.wav");
      }
    }

    public void addedToWorld(World world) {
      Greenfoot.start();
    }
}
