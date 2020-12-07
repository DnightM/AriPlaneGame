package unit.bullet.guided;

import java.awt.image.BufferedImage;

import unit.Unit;
import unit.bullet.Bullet;

public class GuidedBullet extends Bullet {
    public static final int RATE = 50;
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final BufferedImage IMG = getImg("img/bullet/FriendlyBullet.png");

    public GuidedBullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT, Unit.NORTH);
    }

    @Override
    protected int rate() {
        return RATE;
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

    public boolean isGuided() {
        return true;
    }

    protected double acceleration = 1;

    protected int getDeviation(int y) {
        return 0;
    }

    /**
     * 적 비행기를 따라가는 루트를 계산하는 함수
     * 좀더 멋진 포물선을 위해 acceleration 변수를 사용.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return 
     */
    @Override
    protected double[] getPos(int x1, int y1, int x2, int y2) {
        int y = y2 - y1;
        int x = (x2 + getDeviation(y)) - x1;
        double radian = Math.atan2(y, x);
        double xPos = Math.cos(radian) * acceleration;
        double yPos = Math.sin(radian) * acceleration;
        acceleration *= 1.005;
        //        System.out.println(String.format("좌표 : %d %d %d %d", x1, y1, x2, y2));
        //        System.out.println("각도 : " + radian * 180 / Math.PI);
        //        System.out.println("radian " + radian);
        return new double[] { xPos, yPos };
    }
}
