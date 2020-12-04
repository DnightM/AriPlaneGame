package unit.bullet;

public class BulletFactory {
    public static Bullet getBullet(String bulletName, int x, int y) throws Exception {
        switch (bulletName) {
        case "StraightBullet":
            return new StraightBullet(x, y);
        case "EnemyStraightBullet":
            return new EnemyStraightBullet(x, y);
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
        default:
            throw new Exception("Can't find [" + bulletName + "]Bullet");
        }
    }
}
