package game.unit.bullet.spread;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

public class SpreadBullet extends Bullet {
    public static final int RATE = 100;
    protected Bullet[] bulletArr;

    public SpreadBullet(Point pos) {
        this(pos, 0);
        bulletArr = new Bullet[8];
        bulletArr[0] = new SpreadSubBullet(pos, Unit.NORTH);
        bulletArr[1] = new SpreadSubBullet(pos, Unit.NORTH_EAST);
        bulletArr[2] = new SpreadSubBullet(pos, Unit.EAST);
        bulletArr[3] = new SpreadSubBullet(pos, Unit.SOUTH_EAST);
        bulletArr[4] = new SpreadSubBullet(pos, Unit.SOUTH);
        bulletArr[5] = new SpreadSubBullet(pos, Unit.SOUTH_WEST);
        bulletArr[6] = new SpreadSubBullet(pos, Unit.WEST);
        bulletArr[7] = new SpreadSubBullet(pos, Unit.NORTH_WEST);
    }

    public SpreadBullet(Point pos, int direction) {
        super(pos, 0, 0, direction);
    }

    @Override
    protected int rate() {
        return RATE;
    }

    @Override
    protected double speed() {
        return 0;
    }

    @Override
    protected BufferedImage img() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    // 아래 5개를 이렇게 정의해야 다중 총알 구현 가능
    @Override
    public boolean hasSubUnit() {
        return true;
    }

    @Override
    public Unit[] getSubUnitArr() {
        return bulletArr;
    }

    public void draw(Graphics g) {
        return;
    }

    @Override
    public void move() {
        return;
    }

    @Override
    public boolean isCheckCollision() {
        return false;
    }
}
