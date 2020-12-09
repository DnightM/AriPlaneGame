package game.unit.bullet;

import game.Point;
import game.stage.Stage;
import game.unit.Unit;

public abstract class Bullet extends Unit {
    public Bullet(Point pos, int width, int height, double direction) {
        super(new Point(pos.x - width / 2, pos.y), direction);
    }

    protected abstract int rate(); // 높을수록 느려짐

    @Override
    public boolean isCheckCollision() {
        return true;
    }

    @Override
    public void alive(Point pos) {
        super.alive(new Point(pos.x - getWidth() / 2, pos.y));
    }

    @Override
    public void move() {
        super.move();
        if (getX() < 0 || getX() > Stage.WIDTH) {
            kill();
        }
        if (getY() < 0 || getY() > Stage.HEIGHT) {
            kill();
        }
    }
}
