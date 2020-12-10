package game.unit.bullet;

import game.Point;
import game.stage.Stage;
import game.unit.Unit;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Bullet extends Unit {
    public Bullet(Point pos, double width, double height, double direction) {
        super(new Point(pos.x - width / 2, pos.y), direction);
    }

    @Override
    public boolean isCheckCollision() {
        return true;
    }

    @Override
    public void alive(Point pos) {
        super.alive(new Point(pos.x - getWidth() / 2, pos.y));
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform old = g.getTransform();
        g.rotate(getDirection(), getX() + getWidth() / 2, getY() + getHeight() / 2);
        super.draw(g);
        g.setTransform(old);
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
