package unit.plane;

import unit.Unit;
import unit.bullet.Bullet;
import unit.bullet.BulletFactory;

public abstract class Plane extends Unit {
    public abstract String getBulletName();

    private final Unit[] bulletArr;
    private int bulletCount = 0;
    private int bulletArrIdx = 0;

    public Plane(int x, int y, int direction) {
        super(x, y, direction);
        bulletArr = new Unit[UNIT_ARR_LENGTH];
    }

    @Override
    public boolean hasSubUnit() {
        return true;
    }

    @Override
    public Unit[] getSubUnitArr() {
        return bulletArr;
    }

    @Override
    public void move() {
        super.move();
        bulletCount++;
        try {
            if (bulletCount % BulletFactory.getBulletRate(getBulletName()) == 0) {
                try {
                    Unit[] unitArr = getSubUnitArr();
                    Bullet bullet = (Bullet) unitArr[bulletArrIdx];
                    if (bullet != null) {
                        if (bullet.getBulletName().equals(getBulletName())) {
                            if (bullet.isDead()) {
                                bullet.alive(getX(), getY());
                                return;
                            } else {
                                throw new Exception("Bullet Alive");
                            }
                        }
                    }
                    unitArr[bulletArrIdx] = BulletFactory.getBullet(getBulletName(), getX(), getY());
                } finally {
                    if (++bulletArrIdx >= UNIT_ARR_LENGTH) {
                        bulletArrIdx = 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
