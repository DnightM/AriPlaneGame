package game.unit.bullet.spread;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

public class EnemySpreadBullet extends SpreadBullet {
    public EnemySpreadBullet(Point pos) {
        super(pos, 0);
        bulletArr = new Bullet[8];
        bulletArr[0] = new EnemySpreadSubBullet(pos, Unit.NORTH);
        bulletArr[1] = new EnemySpreadSubBullet(pos, Unit.NORTH_EAST);
        bulletArr[2] = new EnemySpreadSubBullet(pos, Unit.EAST);
        bulletArr[3] = new EnemySpreadSubBullet(pos, Unit.SOUTH_EAST);
        bulletArr[4] = new EnemySpreadSubBullet(pos, Unit.SOUTH);
        bulletArr[5] = new EnemySpreadSubBullet(pos, Unit.SOUTH_WEST);
        bulletArr[6] = new EnemySpreadSubBullet(pos, Unit.WEST);
        bulletArr[7] = new EnemySpreadSubBullet(pos, Unit.NORTH_WEST);
    }
}
