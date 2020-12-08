package game.unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.Point;

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

    private Point pos;
    private int direction; // 1:서, 2:북, 4:동, 8:남, 3:북서, 9:남서, 6:북동, 12:남동

    public Unit(Point pos, int direction) {
        this.pos = pos;
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
    public Point getPoint() {
        return pos;
    }

    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
    }

    protected void setX(double x) {
        pos.x = x;
    }

    protected void setY(double y) {
        pos.y = y;
    }

    protected Point getCenterPos() {
        return pos.getCenterPos(getWidth(), getHeight());
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

    public void alive(Point pos) {
        dead = false;
        this.pos = pos;
    }

    // Move
    protected void move(double xsw, double ysw) {
        setX(pos.x + xsw);
        setY(pos.y + ysw);
    }

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
                    if ((i & 1) == 0) {
                        move(-speed, 0);
                    } else {
                        move(0, -speed);
                    }
                } else {
                    // 홀수면 y
                    if ((i & 1) == 0) {
                        move(speed, 0);
                    } else {
                        move(0, speed);
                    }
                }
            }
        }
    }

    // 따라가는 움직임을 표현하기 위한 함수들
    public boolean isGuided() { // 이 함수 return이 true면 move() 함수대신 move(Unit opponent) 함수가 실행됨.
        return false;
    }

    public void move(Unit opponent) {
        double[] range = getGuidedPos(getCenterPos(), opponent.getCenterPos());
        move(range[0], range[1]);
    }

    protected double[] getGuidedPos(Point pos1, Point pos2) {
        return null;
    }

    /**
     * 가장 가까운 적비행기를 찾는 알고리즘
     * @param opponentArr 적비행기 배열
     * @return 가장 가까운 적 비행기
     */
    public Unit getFollowTarget(Unit[] opponentArr) {
        Unit unit = opponentArr[0];
        int range = pos.calRange(opponentArr[0].getPoint());
        int len = opponentArr.length;
        for (int i = 1; i < len; i++) {
            if (opponentArr[i] == null) {
                break;
            }
            if (opponentArr[i].isDead()) {
                continue;
            }
            int temp = pos.calRange(opponentArr[i].getPoint());
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

}
