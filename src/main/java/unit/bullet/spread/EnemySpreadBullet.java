package unit.bullet.spread;

import unit.Unit;
import unit.bullet.Bullet;

public class EnemySpreadBullet extends SpreadBullet {
    public EnemySpreadBullet(int x, int y) {
        super(x, y, 0);
        bulletArr = new Bullet[8];
        bulletArr[0] = new EnemySpreadSubBullet(x, y, Unit.NORTH);
        bulletArr[1] = new EnemySpreadSubBullet(x, y, Unit.NORTH_EAST);
        bulletArr[2] = new EnemySpreadSubBullet(x, y, Unit.EAST);
        bulletArr[3] = new EnemySpreadSubBullet(x, y, Unit.SOUTH_EAST);
        bulletArr[4] = new EnemySpreadSubBullet(x, y, Unit.SOUTH);
        bulletArr[5] = new EnemySpreadSubBullet(x, y, Unit.SOUTH_WEST);
        bulletArr[6] = new EnemySpreadSubBullet(x, y, Unit.WEST);
        bulletArr[7] = new EnemySpreadSubBullet(x, y, Unit.NORTH_WEST);
    }
}
