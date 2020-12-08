package game.unit.bullet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.Point;
import game.unit.bullet.guided.GuidedBullet;
import game.unit.bullet.guided.GuidedLeftBullet;
import game.unit.bullet.guided.GuidedRightBullet;
import game.unit.bullet.spread.EnemySpreadBullet;
import game.unit.bullet.spread.SpreadBullet;
import game.unit.bullet.straight.EnemyStraightBullet;
import game.unit.bullet.straight.StraightBullet;

public class BulletFactory {
    private static final Logger logger = LoggerFactory.getLogger(BulletFactory.class);

    public static Bullet getBullet(String bulletName, Point pos) throws Exception {
        switch (bulletName) {
        case "StraightBullet":
            return new StraightBullet(pos);
        case "EnemyStraightBullet":
            return new EnemyStraightBullet(pos);
        case "SpreadBullet":
            return new SpreadBullet(pos);
        case "GuidedLeftBullet":
            return new GuidedLeftBullet(pos);
        case "GuidedRightBullet":
            return new GuidedRightBullet(pos);
        case "EnemySpreadBullet":
            return new EnemySpreadBullet(pos);
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
