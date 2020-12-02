package unit.plane;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FirstPlane extends Plane {
    private static final double SPEED = 1d;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static BufferedImage IMG = getImg("img/plane/firstPlane.png");

    public FirstPlane(int x, int y) {
        super(x, y, SPEED);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG, getX(), getY(), WIDTH, HEIGHT, null);
    }
}
