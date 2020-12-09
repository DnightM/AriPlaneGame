package game.unit.plane.friendly.satellite;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.plane.friendly.Friendly;

public class Satellite extends Friendly {
    private static final String[] BULLET_NAMES = new String[] { "StraightBullet" };
    private static final BufferedImage IMG = getImg("img/satellite/satellite.png");
    private Friendly friendly;

    public Satellite(Point pos, Friendly friendly) {
        super(pos);
        this.friendly = friendly;

        // 일정 시간 후에 죽게하는 함수
        //        TimeThread t = new TimeThread(() -> {
        //            this.kill();
        //        }, 10000);
        //        t.run();
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
    protected double[] getGuidedPos(Point pos1, Point pos2) {
        int x = pos2.getX() + satellitePosition() - pos1.getX();
        int y = pos2.getY() - pos1.getY();
        if (x == 0 && y == 0) {
            return new double[] { 0d, 0d };
        }
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
