package unit.plane.friendly;

import java.awt.image.BufferedImage;

public class Friendly1 extends Friendly {
    private String[] bulletNames = new String[] { "StraightBullet" };
    private static final BufferedImage IMG = getImg("img/plane/firstPlane.png");

    public Friendly1(int x, int y) {
        super(x, y);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public void setBulletNames(String[] bulletNames) {
        this.bulletNames = bulletNames;
    }

    @Override
    public String[] getBulletNames() {
        return bulletNames;
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
        return 1d;
    }

    @Override
    protected int maxLife() {
        return 10;
    }

}
