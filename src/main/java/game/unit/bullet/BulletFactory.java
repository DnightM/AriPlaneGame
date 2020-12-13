package game.unit.bullet;

import game.Point;
import game.unit.bullet.guided.*;
import game.unit.bullet.spread.*;
import game.unit.bullet.straight.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BulletFactory {
    private static final Logger logger = LoggerFactory.getLogger(BulletFactory.class);

    public static Bullet getBullet(String bulletName, Point pos, int bulletLevel) throws Exception {
        if (bulletName == null)
            return null;

        if (bulletName.equalsIgnoreCase("StraightBullet"))
            return new StraightBullet(pos, bulletLevel);
        if (bulletName.equalsIgnoreCase("SpreadBullet"))
            return new SpreadBullet(pos, bulletLevel);
        if (bulletName.equalsIgnoreCase("GuidedBullet"))
            return new GuidedBullet(pos, bulletLevel);
        if (bulletName.equalsIgnoreCase("EnemyStraightBullet"))
            return new EnemyStraightBullet(pos, bulletLevel);
        if (bulletName.equalsIgnoreCase("EnemySpreadBullet"))
            return new EnemySpreadBullet(pos, bulletLevel);
        if (bulletName.equalsIgnoreCase("EnemyGuidedBullet"))
            return new EnemyGuidedBullet(pos, bulletLevel);

        logger.error("Can't find [" + bulletName + "] Bullet");
        return null;
    }

    public static int getBulletRate(String bulletName) {
        if (bulletName == null)
            return -1;

        if (bulletName.equalsIgnoreCase("StraightBullet"))
            return StraightBullet.RATE;
        if (bulletName.equalsIgnoreCase("SpreadBullet"))
            return SpreadBullet.RATE;
        if (bulletName.equalsIgnoreCase("GuidedBullet"))
            return GuidedBullet.RATE;
        if (bulletName.equalsIgnoreCase("EnemyStraightBullet"))
            return EnemyStraightBullet.RATE;
        if (bulletName.equalsIgnoreCase("EnemySpreadBullet"))
            return EnemySpreadBullet.RATE;
        if (bulletName.equalsIgnoreCase("EnemyGuidedBullet"))
            return EnemyGuidedBullet.RATE;

        logger.error("Can't find [" + bulletName + "] Bullet");
        return -1;
    }
}
