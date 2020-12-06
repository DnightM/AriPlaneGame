package unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Unit {
    private static double DIAGONAL_WIGHT = 1 / Math.sqrt(2);
    public static final int UNIT_ARR_LENGTH = 100;

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
        // TODO 나중에 디버깅 끝나면 지워야함
        //        try {
        //            throw new Exception(this.getClass().getName() + " | dead");
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
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
        if (direction < 0) {
            pos[0] += getPos(degree)[0];
            pos[1] += getPos(degree)[1];
            return;
        }
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

    private double[] getPos(int dgree) {
        double[] speed = new double[2];
        speed[0] = Math.sin(Math.toRadians(dgree));
        speed[1] = Math.cos(Math.toRadians(dgree));
        return speed;
    }
}
