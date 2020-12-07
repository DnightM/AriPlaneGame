package unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Unit {
    private static double DIAGONAL_WIGHT = 1 / Math.sqrt(2);
    public static final int UNIT_ARR_LENGTH = 300; // 적군 개수 limit, 기체당 총알 개수 limit. 공용으로 씀

    // TODO 언젠가 360도로 변경할 예정 근데 그럼 많이 느릴까?
    public static final int STAY = 0;
    public static final int WEST = 1;
    public static final int NORTH = 2;
    public static final int EAST = 4;
    public static final int SOUTH = 8;
    public static final int NORTH_WEST = 3;
    public static final int NORTH_EAST = 6;
    public static final int SOUTH_WEST = 9;
    public static final int SOUTH_EAST = 12;

    private double[] pos;
    private int direction; // 1:서, 2:북, 4:동, 8:남, 3:북서, 9:남서, 6:북동, 12:남동

    public Unit(int x, int y, int direction) {
        this.pos = new double[] { x, y };
        this.direction = direction;
    }

    private boolean dead = false;

    // speed
    protected abstract double speed(); // 0:정지, 음수 가능

    // Image
    /**
     * bufferedImage 변수를 static final 로 선언해놓고 그 변수를 이 함수에 return 시켜야 
     * @return
     */
    protected abstract BufferedImage img();

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract boolean isCheckCollision();

    protected static BufferedImage getImg(String path) {
        try {
            return ImageIO.read(Unit.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void draw(Graphics g) {
        g.drawImage(img(), getX(), getY(), getWidth(), getHeight(), null);
    }

    // Pos
    public int getX() {
        return toInt(pos[0]);
    }

    public int getY() {
        return toInt(pos[1]);
    }

    protected int getTargetX() {
        return getX() + getWidth() / 2;
    }

    protected int getTargetY() {
        return getY() + getHeight() / 2;
    }

    private int toInt(double pos) {
        //                return (int) pos;
        return (int) Math.round(pos);
    }

    // Direction
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Sub Unit
    public boolean hasSubUnit() {
        return false;
    }

    public Unit[] getSubUnitArr() {
        return null;
    }

    public boolean isDead() {
        return dead;
    }

    // life
    public void dead() {
        dead = true;
    }

    public void alive(int x, int y) {
        dead = false;
        pos[0] = x;
        pos[1] = y;
    }

    int degree = 360;

    // Move
    public void move() {
        for (int i = 0; i < 4; i++) {
            int t = 1 << i;
            if ((direction & t) > 0) {
                double speed = speed();
                if (direction != t) {
                    // 대각선이므로 대각선 비율을 곱해줌
                    speed *= DIAGONAL_WIGHT;
                }
                // i=0,1, i=2,3
                if (i < 2) {
                    // 짝수면 x
                    pos[i & 1] -= speed;
                } else {
                    // 홀수면 y
                    pos[i & 1] += speed;
                }
            }
        }
    }

    public void move(Unit opponent) {
        double[] range = getPos(getTargetX(), getTargetY(), opponent.getTargetX(), opponent.getTargetY());
        pos[0] += range[0];
        pos[1] += range[1];
    }

    private double acceleration = 1;

    /**
     * 적 비행기를 따라가는 루트를 계산하는 함수
     * 좀더 멋진 포물선을 위해 acceleration 변수를 사용.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return 
     */
    private double[] getPos(int x1, int y1, int x2, int y2) {
        int y = y2 - y1;
        int x = (x2 - (int) (Math.abs(y) / (acceleration * 2))) - x1;
        double radian = Math.atan2(y, x);
        double xPos = Math.cos(radian) * acceleration;
        double yPos = Math.sin(radian) * acceleration;
        acceleration *= 1.005;
        //        System.out.println(String.format("좌표 : %d %d %d %d", x1, y1, x2, y2));
        //        System.out.println("각도 : " + radian * 180 / Math.PI);
        //        System.out.println("radian " + radian);
        return new double[] { xPos, yPos };
    }

    public boolean isGuided() {
        return false;
    }

    /**
     * 가장 가까운 적비행기를 찾는 알고리즘
     * @param opponentArr 적비행기 배열
     * @return 가장 가까운 적 비행기
     */
    public Unit findProximate(Unit[] opponentArr) {
        Unit unit = opponentArr[0];
        int range = calRange(getX(), getY(), opponentArr[0].getX(), opponentArr[0].getY());
        int len = opponentArr.length;
        for (int i = 1; i < len; i++) {
            if (opponentArr[i] == null) {
                break;
            }
            if (opponentArr[i].isDead()) {
                continue;
            }
            int temp = calRange(getX(), getY(), opponentArr[i].getX(), opponentArr[i].getY());
            if (temp < range) {
                range = temp;
                unit = opponentArr[i];
            }
        }
        return unit;
    }

    /**
     * 거리 계산 함수.
     * 단순 거리 비교를 할 것이기 때문에 루트는 씌우지 않음.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return 거리^2
     */
    private int calRange(int x1, int y1, int x2, int y2) {
        int x = x2 - x1;
        int y = y2 - y1;
        return x * x + y * y;
    }
}
