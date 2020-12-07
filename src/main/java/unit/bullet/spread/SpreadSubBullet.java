package unit.bullet.spread;

import java.awt.image.BufferedImage;

import unit.bullet.Bullet;

public class SpreadSubBullet extends Bullet {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");

    public SpreadSubBullet(int x, int y, int direction) {
        super(x, y, WIDTH, HEIGHT, direction);
    }

    @Override
    protected int rate() {
        return 100;
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
