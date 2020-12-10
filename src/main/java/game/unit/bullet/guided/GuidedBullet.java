package game.unit.bullet.guided;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;

public class GuidedBullet extends Bullet {
    public static final int RATE = 50;
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");

    public GuidedBullet(Point pos) {
        super(pos, WIDTH, HEIGHT, Unit.NORTH);
    }

    @Override
    protected double speed() {
        return 1.5d;
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public boolean isGuided() {
        return true;
    }

    protected double acceleration = 1;

    /**
     * 가중치
     *
     * @param y y좌표
     * @return 가중치
     */
    protected int getWeight(int y) {
        return 0;
    }

    @Override
    protected double getDirection() {
        if (guidedTarget == null) {
            return defalutDirection;
        }
        Point pos1 = getCenterPos();
        Point pos2 = guidedTarget.getCenterPos();
        int y = pos2.getY() - pos1.getY();
        int x = pos2.getX() + getWeight(y) - pos1.getX();
        return Math.atan2(y, x);
    }
}
