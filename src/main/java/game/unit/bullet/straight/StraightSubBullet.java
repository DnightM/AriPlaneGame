package game.unit.bullet.straight;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

import java.awt.image.BufferedImage;

public class StraightSubBullet extends Bullet {
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");
    private static final int WIDTH = 10;
    private static final int HEIGHT = 5;

    public StraightSubBullet(Point pos, double direction) {
        super(pos, WIDTH, HEIGHT, direction);
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
        return 4d;
    }

}
