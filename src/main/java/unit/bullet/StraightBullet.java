package unit.bullet;

import java.awt.image.BufferedImage;

import unit.Unit;

public class StraightBullet extends Bullet {
    public static final int RATE = 10;
    private static final BufferedImage IMG = getImg("img/bullet/straightBullet.png");

    public StraightBullet(int x, int y) {
        this(x, y, Unit.NORTH);
    }

    protected StraightBullet(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    protected int getWidth() {
        return 5;
    }

    @Override
    protected int getHeight() {
        return 5;
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    protected double speed() {
        return 2d;
    }

    @Override
    protected int rate() {
        return 10;
    }

    @Override
    protected int direction() {
        return Unit.NORTH;
    }
}
