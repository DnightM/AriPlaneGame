package game.scenario;

import game.Point;

public class Scenario {
    private static final double[] STAY = new double[] { 0d, 0d };

    private long delay;
    private int posIdx = 1;

    protected Point[] poses = new Point[] {
            new Point(100, 100),
            new Point(200, 200),
            new Point(100, 100),
            new Point(200, 200),
            new Point(100, 100),
    };

    public Scenario(long delay) {
        this.delay = delay;
    }

    public Point getStartPos() {
        return poses[0];
    }

    protected double[] getGuidedPos(Point pos1, Point pos2) {
        int x = pos2.getX() - pos1.getX();
        int y = pos2.getY() - pos1.getY();
        if (x == 0 && y == 0) {
            posIdx++;
            return STAY;
        }
        double radian = Math.atan2(y, x);
        double xPos = Math.cos(radian);
        double yPos = Math.sin(radian);
        return new double[] { xPos, yPos };
    }

    public double[] move(Point pos) {
        if (delay > 0) {
            delay--;
            return STAY;
        }
        if (posIdx == poses.length) {
            return STAY;
        }
        return getGuidedPos(pos, poses[posIdx]);
    }
}
