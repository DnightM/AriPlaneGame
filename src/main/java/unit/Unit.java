package unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Unit {
    private static double DIAGONAL_WIGHT = 1 / Math.sqrt(2);

    public static final int STAY = 0;
    public static final int WEST = 1;
    public static final int NORTH = 2;
    public static final int EAST = 4;
    public static final int SOUTH = 8;
    public static final int NORTH_WEST = 3;
    public static final int NORTH_EAST = 6;
    public static final int SOUTH_WEST = 9;
    public static final int SOUTH_EAST = 12;

    public double[] pos;
    private double speed; // 0:정지, 음수 가능
    private int direction; // 1:서, 2:북, 4:동, 8:남, 3:북서, 9:남서, 6:북동, 12:남동

    public Unit(int x, int y, int direction, double speed) {
        this.pos = new double[] { x, y };
        this.direction = direction;
        this.speed = speed;
    }

    public abstract void draw(Graphics g);

    public void move() {
        for (int i = 0; i < 4; i++) {
            int t = 1 << i;
            if ((direction & t) > 0) {
                double speed = this.speed;
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

    public int getX() {
        return toInt(pos[0]);
    }

    public int getY() {
        return toInt(pos[1]);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    private int toInt(double pos) {
        //                return (int) pos;
        return (int) Math.round(pos);
    }

    protected static BufferedImage getImg(String path) {
        try {
            return ImageIO.read(Unit.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
