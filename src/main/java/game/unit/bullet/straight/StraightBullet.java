package game.unit.bullet.straight;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;
import game.unit.bullet.guided.GuidedSubBullet;

public class StraightBullet extends Bullet {
    public static final int RATE = 10;
    protected Bullet[] bulletArr;

    public StraightBullet(Point pos, int bulletLevel) {
        super(pos);
        bulletArr = new Bullet[bulletLevel];

        int b = bulletLevel & 1;
        int t;
        if (b == 1) {
            bulletArr[0] = new StraightSubBullet(new Point(pos.x, pos.y));
            t = 10;
        } else {
            t = 5;
        }
        for (int i = b; i < (bulletLevel + b) / 2; i++) {
            int idx = i * 2 - b;
            bulletArr[idx] = new StraightSubBullet(new Point(pos.x + t, pos.y));
            bulletArr[idx + 1] = new StraightSubBullet(new Point(pos.x + -t, pos.y));
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
