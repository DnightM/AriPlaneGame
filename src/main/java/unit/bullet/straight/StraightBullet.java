package unit.bullet.straight;

import java.awt.image.BufferedImage;

import unit.Unit;
import unit.bullet.Bullet;

public class StraightBullet extends Bullet {
    public static final int RATE = 10;
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");

    public StraightBullet(int x, int y) {
        this(x, y, Unit.NORTH);
    }

    protected StraightBullet(int x, int y, int direction) {
        super(x, y, WIDTH, HEIGHT, direction);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
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
}
