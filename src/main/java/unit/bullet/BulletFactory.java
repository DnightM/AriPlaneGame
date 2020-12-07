package unit.bullet;

import unit.bullet.guided.GuidedBullet;
import unit.bullet.spread.SpreadBullet;
import unit.bullet.straight.EnemyStraightBullet;
import unit.bullet.straight.StraightBullet;

public class BulletFactory {
    public static Bullet getBullet(String bulletName, int x, int y) throws Exception {
        switch (bulletName) {
        case "StraightBullet":
            return new StraightBullet(x, y);
        case "EnemyStraightBullet":
            return new EnemyStraightBullet(x, y);
        case "SpreadBullet":
            return new SpreadBullet(x, y);
        case "GuidedBullet":
            return new GuidedBullet(x, y);
        default:
            throw new Exception("Can't find [" + bulletName + "]Bullet");
        }
    }

    public static int getBulletRate(String bulletName) throws Exception {
        switch (bulletName) {
        case "StraightBullet":
            return StraightBullet.RATE;
        case "EnemyStraightBullet":
            return EnemyStraightBullet.RATE;
        case "SpreadBullet":
            return SpreadBullet.RATE;
        case "GuidedBullet":
            return GuidedBullet.RATE;
        default:
            throw new Exception("Can't find [" + bulletName + "]Bullet");
        }
    }
}
