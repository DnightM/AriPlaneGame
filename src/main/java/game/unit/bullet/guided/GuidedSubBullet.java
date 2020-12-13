package game.unit.bullet.guided;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

public class GuidedSubBullet extends Bullet {
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");
    private static final int WIDTH = 10;
    private static final int HEIGHT = 5;

    public GuidedSubBullet(Point pos) {
        super(pos, WIDTH, HEIGHT, Unit.NORTH);
    }

    public GuidedSubBullet(Point pos, double direction) {
        super(pos, WIDTH, HEIGHT, direction);
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

    @Override
    public boolean isGuided() {
        return true;
    }
}
