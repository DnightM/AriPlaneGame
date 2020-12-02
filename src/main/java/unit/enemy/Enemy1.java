package unit.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import unit.Unit;

public class Enemy1 extends Unit {
    private static final double SPEED = 0.3d;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static BufferedImage IMG;
    private int health = 5; // 체력

    private int moveRole = 0;

    public Enemy1(int x, int y) {
        super(x, y, WIDTH, HEIGHT, Unit.SOUTH, SPEED);
        InputStream in = getClass().getClassLoader().getResourceAsStream("img/enemy/enemy1.png");
        try {
            IMG = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
