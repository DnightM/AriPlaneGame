package game.unit.bullet.straight;

import game.Point;
import game.unit.bullet.Bullet;

public class EnemyStraightBullet extends StraightBullet {
    public static final int RATE = 60;

    public EnemyStraightBullet(Point pos, int bulletLevel) {
        super(pos, bulletLevel);
        bulletArr = new Bullet[bulletLevel];
        switch (bulletLevel) {
            case 1:
                bulletArr[0] = new EnemyStraightSubBullet(new Point(pos.x, pos.y));
                break;
            case 2:
                bulletArr[0] = new EnemyStraightSubBullet(new Point(pos.x - 5, pos.y));
                bulletArr[1] = new EnemyStraightSubBullet(new Point(pos.x + 5, pos.y));
                break;
            case 3:
                bulletArr[0] = new EnemyStraightSubBullet(new Point(pos.x, pos.y));
                bulletArr[1] = new EnemyStraightSubBullet(new Point(pos.x + 10, pos.y));
                bulletArr[2] = new EnemyStraightSubBullet(new Point(pos.x - 10, pos.y));
                break;
            case 4:
                bulletArr[0] = new EnemyStraightSubBullet(new Point(pos.x - 5, pos.y));
                bulletArr[1] = new EnemyStraightSubBullet(new Point(pos.x + 5, pos.y));
                bulletArr[2] = new EnemyStraightSubBullet(new Point(pos.x - 15, pos.y));
                bulletArr[3] = new EnemyStraightSubBullet(new Point(pos.x + 15, pos.y));
                break;
            case 5:
            default:
                bulletArr[0] = new EnemyStraightSubBullet(new Point(pos.x, pos.y));

                bulletArr[1] = new EnemyStraightSubBullet(new Point(pos.x + 10, pos.y));
                bulletArr[2] = new EnemyStraightSubBullet(new Point(pos.x - 10, pos.y));

                bulletArr[3] = new EnemyStraightSubBullet(new Point(pos.x + 20, pos.y));
                bulletArr[4] = new EnemyStraightSubBullet(new Point(pos.x - 20, pos.y));
                break;
        }
    }
}
