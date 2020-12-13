package game.unit.bullet.spread;

import java.awt.*;
import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

public class SpreadBullet extends Bullet {
    public static final int RATE = 100;
    protected Bullet[] bulletArr;

    public SpreadBullet(Point pos, int bulletLevel) {
        super(pos);
        int benchmark = getBenchMark();

        bulletArr = new Bullet[bulletLevel * 2 + 1];
        double interval = (double) 30 / bulletLevel;
        bulletArr[0] = new SpreadSubBullet(pos, toDirection(benchmark));
        for (int i = 1; i < bulletLevel; i++) {
            double d1 = 360 - interval * i;
            double d2 = (360 + interval * i) % 360;
            bulletArr[i * 2 - 1] = new SpreadSubBullet(pos, toDirection(d1 + benchmark));
            bulletArr[i * 2] = new SpreadSubBullet(pos, toDirection(d2 + benchmark));
        }
    }

    protected int getBenchMark() {
        return 0;
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