package game.unit.bullet.straight;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;

public class EnemyStraightBullet extends StraightBullet {
    public static final int RATE = 60;
    private static final BufferedImage IMG = getImg("img/bullet/EnemyBullet.png");

    public EnemyStraightBullet(Point pos) {
        super(pos, Unit.SOUTH);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }
}
