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

    /**
     * 충돌 검사를 할건지 말건지 결정하는 함수
     * true면 검사하고 false면 검사하지 않음.
     * @return 
     */
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

    protected void setX(int x) {
        pos[0] = x;
    }

    protected void setY(int y) {
        pos[1] = y;
    }

    protected int getTargetX() {
        return getX() + getWidth() / 2;
    }

    protected int getTargetY() {
        return getY() + getHeight() / 2;
    }

    private int toInt(double pos) {
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
    public void kill() {
        dead = true;
    }

    public void alive(int x, int y) {
        dead = false;
        pos[0] = x;
        pos[1] = y;
    }

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

    // 따라가는 움직임을 표현하기 위한 함수들
    public boolean isGuided() { // 이 함수 return이 true면 move() 함수대신 move(Unit opponent) 함수가 실행됨.
        return false;
    }

    public void move(Unit opponent) {
        double[] range = getGuidedPos(getTargetX(), getTargetY(), opponent.getTargetX(), opponent.getTargetY());
        pos[0] += range[0];
        pos[1] += range[1];
        move(); // 따라다니는 애들은 Unit.STAY 이기 때문에 특별한 움직임이 추가되진 않음. 대신 각 클래스마다 정의된 move 함수들이 콜됨.
    }

    protected double[] getGuidedPos(int targetX, int targetY, int targetX2, int targetY2) {
        return null;
    }

    /**
     * 가장 가까운 적비행기를 찾는 알고리즘
     * @param opponentArr 적비행기 배열
     * @return 가장 가까운 적 비행기
     */
    public Unit getFollowTarget(Unit[] opponentArr) {
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
        if (unit.isDead()) {
            return null;
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
