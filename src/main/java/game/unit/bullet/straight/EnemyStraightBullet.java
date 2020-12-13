package game.unit.bullet.straight;

import game.Point;
import game.unit.bullet.Bullet;

public class EnemyStraightBullet extends StraightBullet {
    public static final int RATE = 60;

    public EnemyStraightBullet(Point pos, int bulletLevel) {
        super(pos, bulletLevel);
        bulletArr = new Bullet[bulletLevel];

        int b = bulletLevel & 1;
        int t;
        if (b == 1) {
            bulletArr[0] = new EnemyStraightSubBullet(new Point(pos.x, pos.y));
            t = 10;
        } else {
            t = 5;
        }
        for (int i = b; i < (bulletLevel + b) / 2; i++) {
            int idx = i * 2 - b;
            bulletArr[idx] = new EnemyStraightSubBullet(new Point(pos.x + t, pos.y));
            bulletArr[idx + 1] = new EnemyStraightSubBullet(new Point(pos.x + -t, pos.y));
            t += 10;
        }
    }
}
