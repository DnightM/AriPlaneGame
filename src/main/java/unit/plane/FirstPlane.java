package unit.plane;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import unit.Unit;
import unit.bullet.BulletFactory;

public class FirstPlane extends Plane {
    private static final double SPEED = 1d;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static BufferedImage IMG = getImg("img/plane/firstPlane.png");

    private String bulletName = "straight";
    private int bulletCount = 0;

    public FirstPlane(int x, int y) {
        super(x, y, SPEED);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG, getX(), getY(), WIDTH, HEIGHT, null);
    }

    @Override
    public void setBulletName(String bulletName) {
        this.bulletName = bulletName;
    }

    @Override
    public String getBulletName() {
        return bulletName;
    }

    @Override
    public void move() {
        super.move();
        bulletCount++;
        try {
            if (bulletCount % BulletFactory.getBulletRate(getBulletName()) == 0) {
                bulletList.add(BulletFactory.getBullet(getBulletName(), getX(), getY(), Unit.NORTH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
