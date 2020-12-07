package unit.bullet.straight;

import unit.Unit;

public class EnemyStraightBullet extends StraightBullet {
    public static final int RATE = 60;

    public EnemyStraightBullet(int x, int y) {
        super(x, y, Unit.SOUTH);
    }
}
