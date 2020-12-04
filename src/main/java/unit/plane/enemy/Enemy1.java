package unit.plane.enemy;

import java.awt.image.BufferedImage;

import unit.Unit;

public class Enemy1 extends Enemy {
    private static final BufferedImage IMG = getImg("img/enemy/enemy1.png");

    private int health = 5; // 체력

    public Enemy1(int x, int y) {
        super(x, y, Unit.SOUTH);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    protected int getWidth() {
        return 20;
    }

    @Override
    protected int getHeight() {
        return 20;
    }

    @Override
    protected double speed() {
        return 0.3d;
    }

    @Override
    public String getBulletName() {
        return "EnemyStraightBullet";
    }
}
