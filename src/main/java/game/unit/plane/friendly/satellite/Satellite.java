package game.unit.plane.friendly.satellite;

import java.awt.image.BufferedImage;

import game.Point;
import game.unit.Unit;
import game.unit.plane.friendly.Friendly;

public class Satellite extends Friendly {
    private static final String[] BULLET_NAMES = new String[]{"StraightBullet"};
    private static final BufferedImage IMG = getImg("img/satellite/satellite.png");
    private final Friendly friendly;

    public Satellite(Friendly friendly) {
        super(friendly.getCenterPos());
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

    /**
     * 이걸 아군기로 return하면 항상 아군기만 쫓아다님
     *
     * @param opponentArr 안씀.
     * @return 아군기
     */
    @Override
    public Unit getGuidedTarget(Unit[] opponentArr) {
        return friendly;
    }

    @Override
    protected double getDirection() {
        Point pos1 = getCenterPos();
        Point pos2 = friendly.getCenterPos();
        int x = pos2.getX() + satellitePosition() - pos1.getX();
        int y = pos2.getY() - pos1.getY();
        if (x == 0 && y == 0) {
            return -1;
        }
        return Math.atan2(y, x);
    }
}
