package game.unit.plane.friendly;

import java.awt.image.BufferedImage;

import game.Point;

public class Friendly0 extends Friendly {
    private String[] bulletNames = new String[] { "" };
    private static final BufferedImage IMG = getImg("img/friendly/firstPlane.png");

    public Friendly0(Point pos) {
        super(pos);
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
        return 50;
    }

    @Override
    public int getHeight() {
        return 50;
    }

    @Override
    protected double speed() {
        return 2d;
    }

    @Override
    protected int maxLife() {
        return 10;
    }

}
