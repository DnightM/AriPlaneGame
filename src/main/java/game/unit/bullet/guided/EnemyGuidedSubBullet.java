package game.unit.bullet.guided;

import game.Point;
import game.unit.Unit;

import java.awt.image.BufferedImage;

public class EnemyGuidedSubBullet extends GuidedSubBullet {
    private static final BufferedImage IMG = getImg("img/bullet/EnemyBullet.png");

    public EnemyGuidedSubBullet(Point pos) {
        super(pos, Unit.SOUTH);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }
}
