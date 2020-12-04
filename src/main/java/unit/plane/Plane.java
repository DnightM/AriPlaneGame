package unit.plane;

import java.util.ArrayList;

import unit.Unit;
import unit.bullet.BulletFactory;

public abstract class Plane extends Unit {
    public abstract String getBulletName();

    private final ArrayList<Unit> bulletList;
    private int bulletCount = 0;

    public Plane(int x, int y, int direction) {
        super(x, y, direction);
        bulletList = new ArrayList<>();
    }

    @Override
    public boolean hasSubUnit() {
        return true;
    }

    @Override
    public ArrayList<Unit> getSubUnitList() {
        return bulletList;
    }

    @Override
    public void move() {
        super.move();
        bulletCount++;
        try {
            if (bulletCount % BulletFactory.getBulletRate(getBulletName()) == 0) {
                getSubUnitList().add(BulletFactory.getBullet(getBulletName(), getX(), getY()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
