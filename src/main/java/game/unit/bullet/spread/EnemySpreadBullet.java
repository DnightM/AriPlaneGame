package game.unit.bullet.spread;

import game.Point;
import game.unit.bullet.Bullet;

public class EnemySpreadBullet extends SpreadBullet {
    public EnemySpreadBullet(Point pos, int bulletLevel) {
        super(pos, bulletLevel);
        int benchmark = getBenchMark();

        bulletArr = new Bullet[bulletLevel * 2 + 1];
        double interval = (double) 30 / bulletLevel;
        bulletArr[0] = new EnemySpreadSubBullet(pos, toDirection(benchmark));
        for (int i = 1; i < bulletLevel; i++) {
            double d1 = 360 - interval * i;
            double d2 = (360 + interval * i) % 360;
            bulletArr[i * 2 - 1] = new EnemySpreadSubBullet(pos, toDirection(d1 + benchmark));
            bulletArr[i * 2] = new EnemySpreadSubBullet(pos, toDirection(d2 + benchmark));
        }
    }

    @Override
    protected int getBenchMark() {
        return 180;
    }
}
