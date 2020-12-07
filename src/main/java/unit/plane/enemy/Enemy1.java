package unit.plane.enemy;

import java.awt.image.BufferedImage;

import unit.Unit;

public class Enemy1 extends Enemy {
    private static final BufferedImage IMG = getImg("img/enemy/enemy1.png");

    public Enemy1(int x, int y) {
        super(x, y, Unit.STAY);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public int getWidth() {
        return 20;
    }

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    protected double speed() {
        return 0.3d;
    }

    @Override
    public String[] getBulletNames() {
        return new String[] { "EnemyStraightBullet" };
    }

    @Override
    protected int maxLife() {
        return 10;
    }
}
