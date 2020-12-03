package unit.bullet;

public class BulletFactory {
    public static Bullet getBullet(String bulletName, int x, int y, int direction) throws Exception {
        switch (bulletName) {
        case "straight":
            return new StraightBullet(x, y, direction);
        default:
            throw new Exception("Can't find [" + bulletName + "]Bullet");
        }
    }

    public static int getBulletRate(String bulletName) throws Exception {
        switch (bulletName) {
        case "straight":
            return StraightBullet.RATE;
        default:
            throw new Exception("Can't find [" + bulletName + "]Bullet");
        }
    }
}
