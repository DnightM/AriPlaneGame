package game.unit.bullet.spread;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

public class EnemySpreadBullet extends SpreadBullet {
    public EnemySpreadBullet(Point pos, int bulletLevel) {
        super(pos, bulletLevel);
    }

    @Override
    protected int getBenchMark() {
        return 180;
    }
}
