package unit.bullet;

import unit.Unit;

public abstract class Bullet extends Unit {
    public Bullet(int x, int y, int direction, double speed) {
        super(x, y, direction, speed);
    }
}
