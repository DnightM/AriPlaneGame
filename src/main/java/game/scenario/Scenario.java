package game.scenario;

import game.Point;
import game.stage.Stage;

import java.util.Random;

public abstract class Scenario {
    private final Random r = new Random();

    private long delay;
    private int psIdx;
    private int psLen;
    private double u = 0;

    private final boolean isBezier;

    private Point[] ps;
    private double[] nowPos;

    protected abstract Point[] getPs();

    public Scenario(long delay, boolean isBezier) {
        this.delay = delay;
        this.isBezier = isBezier;
    }

    public Point getStartPos() {
        if (ps == null) {
            // 원래 생성자에 있었는데 여기로 옮김.
            // 자식 클래스에서 파라미터로 전달 받은 생성자에 있는 변수들이 재대로 값을 받지 못하고
            // ps가 세팅되어버려서 문제가 발생. 그래서 여기로 옮김
            this.ps = getPs();
            this.psIdx = 0;
            this.psLen = ps.length;
            this.nowPos = new double[]{ps[0].x, ps[0].y};
        }
        return ps[0];
    }

    public double[] next() {
        if (delay > 0) {
            delay--;
            return nowPos;
        }
        if (psIdx == psLen - 1) {
            return nowPos;
        }
        Point p1 = ps[psIdx];
        Point p2 = ps[psIdx + 1];
        if (isBezier) {
            nowPos = nextBezier(p1, p2);
        } else {
            nowPos = nextStraight(nowPos, p2);
        }
        return nowPos;
    }

    private double[] nextStraight(double[] p1, Point p2) {
        int x = (int) Math.round(p2.x - p1[0]);
        int y = (int) Math.round(p2.y - p1[1]);
        if (x == 0 && y == 0) {
            psIdx++;
            return nowPos;
        }
        double radian = Math.atan2(y, x);
        double xPos = Math.cos(radian);
        double yPos = Math.sin(radian);
        return new double[]{p1[0] + xPos, p1[1] + yPos};
    }

    private Point cp;

    /**
     * @return 이동지점
     */
    private double[] nextBezier(Point p1, Point p2) {
        if (u >= 1) {
            u = 0;
            psIdx++;
            cp = null;
            return p1.toDoubleArr();
        }
        if (cp == null) {
            cp = new Point(r.nextInt(Stage.WIDTH), getRandomVal(p1.y, p2.y));
        }
        double uSqrt = u * u;
        double u2 = 1 - u;
        double u2Sqrt = u2 * u2;
        double xPos = p1.x * u2Sqrt + 2 * cp.x * u2 * u + p2.x * uSqrt;
        double yPos = p1.y * u2Sqrt + 2 * cp.y * u2 * u + p2.y * uSqrt;
        u += 0.00125;
        return new double[]{xPos, yPos};
    }

    private double getRandomVal(double y1, double y2) {
        int t = (int) (y2 - y1);
        if (t > 100) {
            return y1 + 100 + r.nextInt(t - 100);
        } else {
            return y1 + r.nextInt(t + 100) - 100;
        }
    }
}
