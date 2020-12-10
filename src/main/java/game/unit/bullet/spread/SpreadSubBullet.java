package game.unit.bullet.spread;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.bullet.Bullet;

public class SpreadSubBullet extends Bullet {
    private static final int WIDTH = 6;
    private static final int HEIGHT = 3;
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");

    public SpreadSubBullet(Point pos, double direction) {
        super(pos, WIDTH, HEIGHT, direction);
    }

    @Override
    protected double speed() {
        return 2d;
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
}
