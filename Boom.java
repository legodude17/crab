import greenfoot.*;
public class Boom extends Acctor {
    public Boom(int rotate) {
      super();
      setRotation(rotate);
    }
    private int speed = 10;
    public void act() {
      removeTouchingClass(Lobster.class);
      move(speed);
      checkForEdge();
    }
    public void checkForEdge() {
      if (isAtEdge()) {
        getWorld().removeObject(this);
      }
    }
}
