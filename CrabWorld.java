import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.lang.Class;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

public class CrabWorld extends World {
    public int numLobsters = 1;
    public int winWormCount = 8;
    private int wormRandom = 10;
    private int lobsterRandom = 3;

    public CrabWorld() {
        super(1000, 800, 1);
        spawnCrab();
        spawnWorms();
        spawnLobsters();
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
    public int rand(int i) {
      return Greenfoot.getRandomNumber(i);
    }
    public int randomX() {
      return rand(getWidth() + 1);
    }
    public int randomY() {
      return rand(getHeight() + 1);
    }
    public void spawnCrab() {
      addRandom(Crab.class, 1);
    }
    public void spawnWorms() {
      int num = rand(wormRandom) + winWormCount;
      addRandom(Worm.class, num);
    }
    public void spawnLobsters() {
      int num = rand(lobsterRandom) + 1;
      numLobsters = num;
      addRandom(Lobster.class, num);
    }
}
