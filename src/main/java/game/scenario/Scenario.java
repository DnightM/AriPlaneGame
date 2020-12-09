package game.scenario;

import game.Point;

public abstract class Scenario {
    private static final double[] STAY = new double[] { 0d, 0d };

    private long delay;
    private int posIdx = 1;
    private int posesLen;
    private Point[] poses;

    protected abstract Point[] getPoses();

    public Scenario(long delay) {
        this.delay = delay;
    }

    public Point getStartPos() {
        if (poses == null) {
            // 원래 생성자에 있었는데 여기로 옮김.
            // 자식 클래스에서 파라미터로 전달 받은 생성자에 있는 변수들이 재대로 값을 받지 못하고
            // poses가 세팅되어버려서 문제가 발생. 그래서 여기로 옮김
            this.poses = getPoses();
            this.posesLen = poses.length;
        }
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
        if (posIdx == posesLen) {
            return STAY;
        }
        return getGuidedPos(pos, poses[posIdx]);
    }
}
