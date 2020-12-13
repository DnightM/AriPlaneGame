package game.unit;

import game.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class Unit {
    public static final int UNIT_ARR_LENGTH = 300; // 적군 개수 limit, 기체당 총알 개수 limit. 공용으로 씀

    public static final double STAY = -1;
    public static final double EAST = Math.toRadians(0);
    public static final double SOUTH = Math.toRadians(90);
    public static final double WEST = Math.toRadians(180);
    public static final double NORTH = Math.toRadians(270);
    public static final double SOUTH_EAST = Math.toRadians(45);
    public static final double SOUTH_WEST = Math.toRadians(135);
    public static final double NORTH_WEST = Math.toRadians(225);
    public static final double NORTH_EAST = Math.toRadians(315);

    protected Point pos;
    private double direction;

    public Unit(Point pos, double direction) {
        this.pos = pos;
        this.direction = direction;
    }

    private boolean dead = false;

    // speed
    protected abstract double speed(); // 0:정지, 음수 가능

    // Image

    /**
     * bufferedImage 변수를 static final 로 선언해놓고 그 변수를 이 함수에 return 시켜야
     *
     * @return 이미지
     */
    protected abstract BufferedImage img();

    public abstract int getWidth();

    public abstract int getHeight();

    /**
     * 충돌 검사를 할건지 말건지 결정하는 함수
     * true면 검사하고 false면 검사하지 않음.
     *
     * @return 충돌 체크를 할지 여부
     */
    public abstract boolean isCheckCollision();

    protected static BufferedImage getImg(String path) {
        try {
            return ImageIO.read(Objects.requireNonNull(Unit.class.getClassLoader().getResourceAsStream(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void draw(Graphics2D g) {
        g.drawImage(img(), getX(), getY(), getWidth(), getHeight(), null);
    }

    // Pos
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

    public Point getCenterPos() {
        return pos.getCenterPos(getWidth(), getHeight());
    }

    // Direction
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * 가야할 방향을 리턴함.
     *
     * @return direction(radian)
     */
    protected double getDirection() {
        if (guidedTarget == null) {
            return direction;
        }
        Point pos1 = getCenterPos();
        Point pos2 = guidedTarget.getCenterPos();
        int y = pos2.getY() - pos1.getY();
        int x = pos2.getX() - pos1.getX();
        return Math.atan2(y, x);
    }

    // Sub Unit
    public Unit[] getSubUnitArr() {
        return new Unit[]{};
    }

    public boolean isDead() {
        return dead;
    }

    // life
    public void kill() {
        dead = true;
    }

    protected void alive(Point pos) {
        dead = false;
        this.pos = pos;
    }

    // Move
    protected void directMove(double xPos, double yPos) {
        setX(xPos);
        setY(yPos);
    }

    public void move() {
        if (getDirection() == Unit.STAY) {
            return;
        }
        double xPos = Math.cos(getDirection()) * speed();
        double yPos = Math.sin(getDirection()) * speed();
        directMove(pos.x + xPos, pos.y + yPos);
    }

    // 따라가는 움직임을 표현하기 위한 함수들
    protected Unit guidedTarget;

    public void setGuidedTarget(Unit opponent) {
        this.guidedTarget = opponent;
    }

    public boolean isGuided() {
        return false;
    }

    /**
     * 가장 가까운 적비행기를 찾는 알고리즘
     *
     * @param opponentArr 적비행기 배열
     * @return 가장 가까운 적 비행기
     */
    public Unit getGuidedTarget(Unit[] opponentArr) {
        // Unit 클래스에 있어야만 위성 유닛이 아군기를 타켓으로 지정할 수 있음.
        Unit target = null;
        int range = 1000000;
        for (Unit opponent : opponentArr) {
            if (opponent == null) {
                break;
            }
            if (opponent.isDead()) {
                continue;
            }
            int temp = getCenterPos().calRange(opponent.getCenterPos());
            if (temp < range) {
                range = temp;
                target = opponent;
            }
        }
        if (target == null || target.isDead()) {
            return null;
        }
        return target;
    }
}
