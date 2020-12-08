package game.unit.plane.enemy;

import game.Point;
import game.stage.Stage;
import game.unit.plane.Plane;

public abstract class Enemy extends Plane {
    public Enemy(Point pos, int direction) {
        super(pos, direction);
    }

    @Override
    public void move(double xsw, double ysw) {
        super.move(xsw, ysw);
        if (getX() < 0 || getX() > Stage.WIDTH) {
            kill();
        }
        if (getY() < 0 || getY() > Stage.HEIGHT) {
            kill();
        }
    }
}
