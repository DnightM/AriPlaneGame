package game.unit.bullet;

import game.Point;
import game.stage.Stage;
import game.unit.Unit;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Bullet extends Unit {
    private final double direction;

    /**
     * 총알을 담고 있는 생성자
     * 발사되는 총알 객체가 아님
     *
     * @param pos 총알이 생성될 위치
     */
    public Bullet(Point pos) {
        super(pos, Unit.STAY);
        this.direction = Unit.STAY;
    }

    /**
     * 직접 발사되는 총알 객체
     *
     * @param pos       위치
     * @param width     가로
     * @param height    세로
     * @param direction 방향
     */
    public Bullet(Point pos, double width, double height, double direction) {
        super(new Point(pos.x - width / 2, pos.y), direction);
        this.direction = direction;
    }

    @Override
    public boolean isCheckCollision() {
        return direction != Unit.STAY;
    }

    public void alive(Point pos, int bulletLevel) {
        super.alive(new Point(pos.x - (double) getWidth() / 2, pos.y));
    }

    @Override
    public void draw(Graphics2D g) {
        if (direction == Unit.STAY) {
            // 발사되는 총알 객체가 아니라는 의미
            return;
        }
        AffineTransform old = g.getTransform();
        g.rotate(getDirection(), pos.x + (double) getWidth() / 2, pos.y + (double) getHeight() / 2);
        super.draw(g);
        g.setTransform(old);
    }

    @Override
    public void move() {
        if (direction == Unit.STAY) {
            // 발사되는 총알 객체가 아니라는 의미
            return;
        }
        super.move();
        if (getX() < 0 || getX() > Stage.WIDTH) {
            kill();
        }
        if (getY() < 0 || getY() > Stage.HEIGHT) {
            kill();
        }
    }

    protected double toDirection(double dgree) {
        // 오른쪽이 0도 이기 때문에 해깔리지 않도록 아래 숫자들로 보정해줌.
        // 북쪽이 0도로 맞춰줌
        // 0 -> 270
        // 90 -> 0
        // 180 -> 90
        // 270 -> 180
        dgree = (dgree + 270) % 360;
        return Math.toRadians(dgree);
    }
}
