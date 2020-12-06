package unit.bullet.spread;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import unit.Unit;
import unit.bullet.Bullet;

public class SpreadBullet extends Bullet {
    public static final int RATE = 100;
    private Bullet[] bulletArr;

    public SpreadBullet(int x, int y) {
        this(x, y, 0);
        bulletArr = new Bullet[8];
        bulletArr[0] = new SpreadSubBullet(x, y, Unit.NORTH);
        bulletArr[1] = new SpreadSubBullet(x, y, Unit.NORTH_EAST);
        bulletArr[2] = new SpreadSubBullet(x, y, Unit.EAST);
        bulletArr[3] = new SpreadSubBullet(x, y, Unit.SOUTH_EAST);
        bulletArr[4] = new SpreadSubBullet(x, y, Unit.SOUTH);
        bulletArr[5] = new SpreadSubBullet(x, y, Unit.SOUTH_WEST);
        bulletArr[6] = new SpreadSubBullet(x, y, Unit.WEST);
        bulletArr[7] = new SpreadSubBullet(x, y, Unit.NORTH_WEST);
    }

    public SpreadBullet(int x, int y, int direction) {
        super(x, y, 0, 0, direction);
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
