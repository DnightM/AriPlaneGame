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
        if (bulletName == null)
            return null;

        if (bulletName.equalsIgnoreCase("StraightBullet"))
            return new StraightBullet(pos);
        if (bulletName.equalsIgnoreCase("EnemyStraightBullet"))
            return new EnemyStraightBullet(pos);
        if (bulletName.equalsIgnoreCase("SpreadBullet"))
            return new SpreadBullet(pos);
        if (bulletName.equalsIgnoreCase("GuidedLeftBullet"))
            return new GuidedLeftBullet(pos);
        if (bulletName.equalsIgnoreCase("GuidedRightBullet"))
            return new GuidedRightBullet(pos);
        if (bulletName.equalsIgnoreCase("EnemySpreadBullet"))
            return new EnemySpreadBullet(pos);

        logger.error("Can't find [" + bulletName + "] Bullet");
        return null;
    }

    public void run() {

    }

    public static int getBulletRate(String bulletName) throws Exception {
        if (bulletName == null)
            return -1;

        if (bulletName.equalsIgnoreCase("StraightBullet"))
            return StraightBullet.RATE;
        if (bulletName.equalsIgnoreCase("EnemyStraightBullet"))
            return EnemyStraightBullet.RATE;
        if (bulletName.equalsIgnoreCase("SpreadBullet"))
            return SpreadBullet.RATE;
        if (bulletName.equalsIgnoreCase("GuidedLeftBullet") || bulletName.equalsIgnoreCase("GuidedRightBullet"))
            return GuidedBullet.RATE;
        if (bulletName.equalsIgnoreCase("EnemySpreadBullet"))
            return EnemySpreadBullet.RATE;

        logger.error("Can't find [" + bulletName + "] Bullet");
        return -1;
    }
}
