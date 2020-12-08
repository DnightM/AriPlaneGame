package unit.plane.friendly.satellite;

import java.awt.image.BufferedImage;

import unit.Unit;
import unit.plane.friendly.Friendly;

public class Satellite extends Friendly {
    private static final String[] BULLET_NAMES = new String[] { "StraightBullet" };
    private static final BufferedImage IMG = getImg("img/satellite/satellite.png");
    private Friendly friendly;

    public Satellite(int x, int y, Friendly friendly) {
        super(x, y);
        this.friendly = friendly;
    }

    @Override
    public void setBulletNames(String[] bulletNames) {

    }

    @Override
    public String[] getBulletNames() {
        return BULLET_NAMES;
    }

    @Override
    protected int maxLife() {
        return 1;
    }

    @Override
    protected double speed() {
        return 1d;
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public int getWidth() {
        return 10;
    }

    @Override
    public int getHeight() {
        return 10;
    }

    @Override
    public boolean isCheckCollision() {
        return false;
    }

    @Override
    public boolean isGuided() {
        return true;
    }

    protected int satellitePosition() {
        return 0;
    }

    @Override
    protected double[] getGuidedPos(int x1, int y1, int x2, int y2) {
        int y = y2 - y1;
        int x = x2 + satellitePosition() - x1;
        double radian = Math.atan2(y, x);
        double xPos = Math.cos(radian);
        double yPos = Math.sin(radian);
        return new double[] { xPos, yPos };
    }

    @Override
    public Unit getFollowTarget(Unit[] opponentArr) {
        // 따라다닐 비행기 리턴하면됨
        return friendly;
    }
}
