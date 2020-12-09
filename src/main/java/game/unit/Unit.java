package game.unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.Point;
import game.unit.plane.friendly.Friendly;

public abstract class Unit {
    public static final int UNIT_ARR_LENGTH = 300; // 적군 개수 limit, 기체당 총알 개수 limit. 공용으로 씀

    // TODO 언젠가 360도로 변경할 예정 근데 그럼 많이 느릴까?
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
        // 1:서, 2:북, 4:동, 8:남, 3:북서, 9:남서, 6:북동, 12:남동
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
    protected void directMove(double xsw, double ysw) {
        setX(pos.x + xsw);
        setY(pos.y + ysw);
    }

    public void move() {
        if (isGuided() && guidedTargetOpponent != null) {
            guidedMove();
            return;
        }
        if (direction == -1) {
            // Unit.STAY
            return;
        }
        double xPos = Math.cos(direction) * speed();
        double yPos = Math.sin(direction) * speed();
        directMove(xPos, yPos);
    }

    // 따라가는 움직임을 표현하기 위한 함수들
    public boolean isGuided() { // 이 함수 return이 true면 move() 함수대신 move(Unit opponent) 함수가 실행됨.
        return false;
    }

    private Unit guidedTargetOpponent;

    private void guidedMove() {
        double[] move = getGuidedPos(getCenterPos(), guidedTargetOpponent.getCenterPos());
        directMove(move[0], move[1]);
    }

    public void setGuidedTarget(Unit opponent) {
        this.guidedTargetOpponent = opponent;
    }

    protected double[] getGuidedPos(Point pos1, Point pos2) {
        return null;
    }

    /**
     * 가장 가까운 적비행기를 찾는 알고리즘
     * @param opponentArr 적비행기 배열
     * @return 가장 가까운 적 비행기
     */
    public Unit getGuidedTarget(Unit[] opponentArr) {
        // Unit 클래스에 있어야만 위성 유닛이 아군기를 타켓으로 지정할 수 있음.
        Unit opponent = opponentArr[0];
        int range = getCenterPos().calRange(opponentArr[0].getCenterPos());
        int len = opponentArr.length;
        for (int i = 1; i < len; i++) {
            if (opponentArr[i] == null) {
                break;
            }
            if (opponentArr[i].isDead()) {
                continue;
            }
            int temp = getCenterPos().calRange(opponentArr[i].getCenterPos());
            if (temp < range) {
                range = temp;
                opponent = opponentArr[i];
            }
        }
        if (opponent.isDead()) {
            return null;
        }
        return opponent;
    }
}
