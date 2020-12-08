package unit.bullet;

import stage.Stage;
import unit.Unit;

public abstract class Bullet extends Unit {
    public Bullet(int x, int y, int width, int height, int direction) {
        super(x - width / 2, y, direction);
    }

    protected abstract int rate(); // 높을수록 느려짐

    @Override
    public boolean isCheckCollision() {
        return true;
    }

    @Override
    public void alive(int x, int y) {
        super.alive(x - getWidth() / 2, y);
    }

    @Override
    public void move() {
        super.move();
        if (getX() < 0 || getX() > Stage.WIDTH) {
            dead();
        }
        if (getY() < 0 || getY() > Stage.HEIGHT) {
            dead();
        }
    }
}
