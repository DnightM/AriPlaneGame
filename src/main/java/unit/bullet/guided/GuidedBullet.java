package unit.bullet.guided;

import java.awt.image.BufferedImage;

import unit.Unit;
import unit.bullet.Bullet;

public class GuidedBullet extends Bullet {
    public static final int RATE = 50;
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final BufferedImage IMG = getImg("img/bullet/StraightBullet.png");

    public GuidedBullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT, Unit.NORTH);
    }

    @Override
    protected int rate() {
        return RATE;
    }

    @Override
    protected double speed() {
        return 1.5d;
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    public boolean isGuided() {
        return true;
    }
}
