package game.unit.bullet.spread;

import java.awt.image.BufferedImage;

import game.Point;

public class EnemySpreadSubBullet extends SpreadSubBullet {
    private static final BufferedImage IMG = getImg("img/bullet/EnemyBullet.png");

    public EnemySpreadSubBullet(Point pos, int direction) {
        super(pos, direction);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }
}
