package unit.bullet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class StraightBullet extends Bullet {
    private static final double SPEED = 2d;
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static BufferedImage IMG = getImg("img/bullet/straightBullet.png");

    public static final int RATE = 10; // 높을수록 느려짐

    public StraightBullet(int x, int y, int direction) {
        super(x, y, direction, SPEED);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG, getX(), getY(), WIDTH, HEIGHT, null);
    }
}
