package unit.plane.enemy;

import stage.Stage;
import unit.plane.Plane;

public abstract class Enemy extends Plane {
    public Enemy(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void move() {
        super.move();
        if (getX() < 0 || getX() > Stage.WIDTH) {
            dead();
        }
        if (getY() < 0 || getY() > Stage.HEIGHT) {
            dead();
        }
    }
}
