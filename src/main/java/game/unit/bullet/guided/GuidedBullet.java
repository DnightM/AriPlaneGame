package game.unit.bullet.guided;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

import java.awt.image.BufferedImage;

public class GuidedBullet extends Bullet {
    public static final int RATE = 50;
    protected Bullet[] bulletArr;

    public GuidedBullet(Point pos, int bulletLevel) {
        super(pos);
        bulletArr = new Bullet[bulletLevel];

        int b = bulletLevel & 1;
        int t;
        if (b == 1) {
            bulletArr[0] = new GuidedSubBullet(new Point(pos.x, pos.y), Unit.NORTH);
            t = 10;
        } else {
            t = 5;
        }
        for (int i = b; i < (bulletLevel + b) / 2; i++) {
            int idx = i * 2 - b;
            bulletArr[idx] = new GuidedSubBullet(new Point(pos.x + t, pos.y), Unit.NORTH);
            bulletArr[idx + 1] = new GuidedSubBullet(new Point(pos.x + -t, pos.y), Unit.NORTH);
            t += 10;
        }

    }

    @Override
    protected double speed() {
        return -1;
    }

    @Override
    protected BufferedImage img() {
        return null;
    }

    @Override
    public int getWidth() {
        return -1;
    }

    @Override
    public int getHeight() {
        return -1;
    }

    @Override
    public Unit[] getSubUnitArr() {
        return bulletArr;
    }
}
