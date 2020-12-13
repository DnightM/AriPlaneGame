package game.unit.bullet.guided;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

import java.awt.image.BufferedImage;

public class EnemyGuidedBullet extends GuidedBullet {
    public static final int RATE = 200;

    public EnemyGuidedBullet(Point pos, int bulletLevel) {
        super(pos, bulletLevel);
        bulletArr = new Bullet[bulletLevel];
        // 총알과 총알 간격은 10
        switch (bulletLevel) {
            case 1:
                bulletArr[0] = new GuidedSubBullet(new Point(pos.x, pos.y), Unit.NORTH);
                break;
            case 2:
                bulletArr[0] = new GuidedSubBullet(new Point(pos.x - 5, pos.y), Unit.NORTH);
                bulletArr[1] = new GuidedSubBullet(new Point(pos.x + 5, pos.y), Unit.NORTH);
                break;
            case 3:
                bulletArr[0] = new GuidedSubBullet(new Point(pos.x, pos.y), Unit.NORTH);
                bulletArr[1] = new GuidedSubBullet(new Point(pos.x + 10, pos.y), Unit.NORTH);
                bulletArr[2] = new GuidedSubBullet(new Point(pos.x - 10, pos.y), Unit.NORTH);
                break;
            case 4:
                bulletArr[0] = new GuidedSubBullet(new Point(pos.x - 5, pos.y), Unit.NORTH);
                bulletArr[1] = new GuidedSubBullet(new Point(pos.x + 5, pos.y), Unit.NORTH);
                bulletArr[2] = new GuidedSubBullet(new Point(pos.x - 15, pos.y), Unit.NORTH);
                bulletArr[3] = new GuidedSubBullet(new Point(pos.x + 15, pos.y), Unit.NORTH);
                break;
            case 5:
            default:
                bulletArr[0] = new GuidedSubBullet(new Point(pos.x, pos.y), Unit.NORTH);

                bulletArr[1] = new GuidedSubBullet(new Point(pos.x + 10, pos.y), Unit.NORTH);
                bulletArr[2] = new GuidedSubBullet(new Point(pos.x - 10, pos.y), Unit.NORTH);

                bulletArr[3] = new GuidedSubBullet(new Point(pos.x + 20, pos.y), Unit.NORTH);
                bulletArr[4] = new GuidedSubBullet(new Point(pos.x - 20, pos.y), Unit.NORTH);
                break;
        }
    }

    @Override
    protected double speed() {
        return -1;
    }

    @Override
    protected BufferedImage img() {
        return null;
    }

    @Override
    public int getWidth() {
        return -1;
    }

    @Override
    public int getHeight() {
        return -1;
    }
}
