package game;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return toInt(x);
    }

    public int getY() {
        return toInt(y);
    }

    private int toInt(double pos) {
        return (int) Math.round(pos);
    }

    /**
     * 거리 계산 함수.
     * 단순 거리 비교를 할 것이기 때문에 루트는 씌우지 않음.
     *
     * @param target 목표점
     * @return 거리^2
     */
    public int calRange(Point target) {
        int x = target.getX() - getX();
        int y = target.getY() - getY();
        return x * x + y * y;
    }

    public Point getCenterPos(double width, double height) {
        return new Point(getX() + width / 2, getY() + height / 2);
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}
