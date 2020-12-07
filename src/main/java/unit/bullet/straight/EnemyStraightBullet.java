package unit.bullet.straight;

import java.awt.image.BufferedImage;

import unit.Unit;

public class EnemyStraightBullet extends StraightBullet {
    public static final int RATE = 60;
    private static final BufferedImage IMG = getImg("img/bullet/EnemyBullet.png");

    public EnemyStraightBullet(int x, int y) {
        super(x, y, Unit.SOUTH);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }
}
