package game.unit.plane.friendly;

import java.awt.image.BufferedImage;

import game.Point;

public class FriendlySpread extends Friendly {
    private String[] bulletNames = new String[] {
            "SpreadBullet"
    };
    private static final BufferedImage IMG = getImg("img/friendly/friendly.png");

    public FriendlySpread(Point pos) {
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
    protected double speed() {
        return 2d;
    }

    @Override
    protected int maxLife() {
        return 10;
    }

}
