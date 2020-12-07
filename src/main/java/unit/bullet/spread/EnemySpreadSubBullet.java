package unit.bullet.spread;

import java.awt.image.BufferedImage;

public class EnemySpreadSubBullet extends SpreadSubBullet {
    private static final BufferedImage IMG = getImg("img/bullet/EnemyBullet.png");

    public EnemySpreadSubBullet(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }
}
