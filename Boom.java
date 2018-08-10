import greenfoot.*;
public class Boom extends Acctor {
    public Boom(int rotate) {
      super();
      setRotation(rotate);
    }
    private int speed = 10;
    public void act() {
      if (removeTouchingClass(Lobster.class)) {
        CrabWorld world = (CrabWorld) getWorld();
        world.numLobsters--;
        if (world.numLobsters == 0) {
          world.spawnLobsters();
        }
      };
      move(speed);
      checkForEdge();
    }
    public void checkForEdge() {
      if (isAtEdge()) {
        getWorld().removeObject(this);
      }
    }
}
