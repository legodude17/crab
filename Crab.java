import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
public class Crab extends Acctor {
    public Crab() {
      // Custom constructor so that we can have it init certain frames
      super();
      initFrames(new String[]{"crab", "crab2"}, 10);
      showScore();
    }
    private int wyrmsEetin = 0;
    private int speed = 5;
    private int turnDeg = 5;
    private int reloadTime = 50;
    private int reloadState = reloadTime;
    private boolean auto = false;

    public void act() {
        super.act();
        if (auto) {
          if (seek(Lobster.class)) {
            move(-speed);
            shoot();
          } else {
            seek(Worm.class);
            move(speed);
          }
          turnAtEdge();
        } else {
          turnTowardsMouse();
          doKeyboard();
        }
        eat();
        reload();
        tauto();
    }
    public void turnAtEdge() {
      if (isAtEdge()) {
          turn(17);
      }
    }
    public void turnTowardsMouse() {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      if(mouse != null){
        turnTowards(mouse.getX(), mouse.getY());
      }
    }
    public void doKeyboard() {
      if (key("up") || key("w")) {
        move(speed);
      }
      if (key("down") || key("s")) {
        move(-speed);
      }
      if (key("space")) {
        shoot();
      }
      if (key("q")) {
        reloadState = reloadTime;
      }
    }
    public void tauto() {
      if (key("h")) {
        auto = !auto;
      }
    }
    public void shoot() {
      if (reloadState > reloadTime) {
        getWorld().addObject(new Boom(getRotation()), getX(), getY());
        reloadState = 0;
      }
    }
    public void reload() {
      reloadState++;
    }
    public void eat() {
      if (removeTouchingClass(Worm.class)) {
        showScore();
        Greenfoot.playSound("slurp.wav");
        wyrmsEetin++;
        if (wyrmsEetin == 8) {
          youWin();
        }
      }
    }
    public void youWin() {
      Greenfoot.playSound("fanfare.wav");
    }
    public void showScore() {
      World world = getWorld();
      if (world != null) {
        getWorld().showText("Score: " + wyrmsEetin, 50, 50);
      }
    }
}
