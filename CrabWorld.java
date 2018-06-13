import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.lang.Class;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

public class CrabWorld extends World {
    public CrabWorld() {
        super(1000, 800, 1);
        addRandom(Crab.class, 1);
        addRandom(Lobster.class, Greenfoot.getRandomNumber(10) + 1);
        addRandom(Worm.class, Greenfoot.getRandomNumber(20) + 20);
        Greenfoot.playSound("crab_rAve.js.wav");
    }
    public void addRandom(Class<? extends Actor> cls, int n) {
      for (int i = 0; i < n; i++) {
        try {
          addObject(cls.newInstance(), randomX(), randomY());
        } catch (InstantiationException e) {

        } catch (IllegalAccessException ex) {

        }
      }
    }
    public int randomX() {
      return Greenfoot.getRandomNumber(getWidth() + 1);
    }
    public int randomY() {
      return Greenfoot.getRandomNumber(getHeight() + 1);
    }
}
