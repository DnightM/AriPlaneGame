package game.unit.bullet.straight;

import game.Point;
import game.unit.Unit;

import java.awt.image.BufferedImage;

public class EnemyStraightSubBullet extends StraightSubBullet {
    private static final BufferedImage IMG = getImg("img/bullet/EnemyBullet.png");

    public EnemyStraightSubBullet(Point pos) {
        super(pos, Unit.SOUTH);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }
}
