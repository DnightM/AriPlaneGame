package unit.bullet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import unit.bullet.guided.GuidedBullet;
import unit.bullet.guided.GuidedLeftBullet;
import unit.bullet.guided.GuidedRightBullet;
import unit.bullet.spread.EnemySpreadBullet;
import unit.bullet.spread.SpreadBullet;
import unit.bullet.straight.EnemyStraightBullet;
import unit.bullet.straight.StraightBullet;

public class BulletFactory {
    private static final Logger logger = LoggerFactory.getLogger(BulletFactory.class);

    public static Bullet getBullet(String bulletName, int x, int y) throws Exception {
        switch (bulletName) {
        case "StraightBullet":
            return new StraightBullet(x, y);
        case "EnemyStraightBullet":
            return new EnemyStraightBullet(x, y);
        case "SpreadBullet":
            return new SpreadBullet(x, y);
        case "GuidedLeftBullet":
            return new GuidedLeftBullet(x, y);
        case "GuidedRightBullet":
            return new GuidedRightBullet(x, y);
        case "EnemySpreadBullet":
            return new EnemySpreadBullet(x, y);
        default:
            logger.error("Can't find [" + bulletName + "] Bullet | EXIT Programe");
            System.exit(0);
            return null;
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
        case "GuidedLeftBullet":
        case "GuidedRightBullet":
            return GuidedBullet.RATE;
        case "EnemySpreadBullet":
            return EnemySpreadBullet.RATE;
        default:
            logger.error("Can't find [" + bulletName + "] Bullet | EXIT Programe");
            System.exit(0);
            return -1;
        }
    }
}
