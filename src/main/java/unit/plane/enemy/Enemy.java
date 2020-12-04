package unit.plane.enemy;

import unit.plane.Plane;

public abstract class Enemy extends Plane {
    public Enemy(int x, int y, int direction) {
        super(x, y, direction);
    }
}
