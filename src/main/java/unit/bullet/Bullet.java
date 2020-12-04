package unit.bullet;

import unit.Unit;

public abstract class Bullet extends Unit {
    public Bullet(int x, int y, int direction) {
        super(x, y, direction);
    }

    protected abstract int direction();

    protected abstract int rate(); // 높을수록 느려짐
}
