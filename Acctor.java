import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Class;
import java.util.List;
/**
 * Write a description of class Acctor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Acctor extends Actor {
    /**
     * Act - do whatever the Acctor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] images;
    private int frame;
    private int counter;
    private int apn;

    public void act() {
      counter++;
      if (counter != apn) return;
      counter = 0;
      frame++;
      if (frame >= images.length) {
        frame = 0;
      }
      setImage(images[frame]);
    }
    public boolean removeTouchingClass(Class<? extends Actor> cls) {
      if (isTouching(cls)) {
        removeTouching(cls);
        return true;
      }
      return false;
    }
    public boolean seek(Class<? extends Actor> cls) {
      List<? extends Actor> things = getWorld().getObjects(cls);
      if(!things.isEmpty()) {
        turnTowards(things.get(0).getX(), things.get(0).getY());
        return true;
      }
      return false;
    }
    public void initFrames(String[] frames, int actsPerAn) {
      apn = actsPerAn;
      images = new GreenfootImage[frames.length];
      for (int i = 0; i < frames.length; i++) {
        images[i] = new GreenfootImage(frames[i].concat(".png"));
      }
    }
    public boolean key(String k) {
      return Greenfoot.isKeyDown(k);
    }
}
