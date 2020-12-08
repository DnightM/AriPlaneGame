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

    /**
     * 가중치
     * @param y
     * @return 가중치
     */
    protected int getWeight(int y) {
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
    protected double[] getGuidedPos(Point pos1, Point pos2) {
        int y = pos2.getY() - pos1.getY();
        int x = pos2.getX() + getWeight(y) - pos1.getX();
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
