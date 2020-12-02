package unit.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import unit.Unit;

public class Enemy1 extends Unit {
    private static final double SPEED = 0.3d;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static BufferedImage IMG = getImg("img/enemy/enemy1.png");

    private int health = 5; // 체력
    private int moveRole = 0;

    public Enemy1(int x, int y) {
        super(x, y, Unit.SOUTH, SPEED);
    }

    public void move() {
        super.move();
        moveRole++;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG, getX(), getY(), WIDTH, HEIGHT, null);
    }
}
