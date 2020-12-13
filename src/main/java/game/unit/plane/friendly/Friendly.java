package game.unit.plane.friendly;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.Point;
import game.stage.Stage;
import game.unit.Unit;
import game.unit.plane.Plane;

public abstract class Friendly extends Plane {
    private static final Logger logger = LoggerFactory.getLogger(Friendly.class);
    private static final double DIAGONAL_WIGHT = 1 / Math.sqrt(2);

    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    //    private static final int STAY = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int EAST = 4;
    private static final int SOUTH = 8;
    //    private static final int NORTH_WEST = 3;
    //    private static final int NORTH_EAST = 6;
    //    private static final int SOUTH_WEST = 9;
    //    private static final int SOUTH_EAST = 12;

    private int direction = 0;

    public abstract void setBulletNames(String[] bulletNames);

    public Friendly(Point pos) {
        super(pos, Unit.STAY);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public void kill() {
        super.kill();
        logger.info("friendly dead");
    }

    @Override
    public void move() {
        super.move();
        shotBullet();

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
                        directMove(getX() - speed, getY());
                    } else {
                        directMove(getX(), getY() - speed);
                    }
                } else {
                    // 홀수면 y
                    if ((i & 1) == 0) {
                        directMove(getX() + speed, getY());
                    } else {
                        directMove(getX(), getY() + speed);
                    }
                }
            }
        }
        // 아래 if 4개는 stage에서 정의된 width height 범위를 비행기가 넘어가지 못하도록 제한하는 역할을 함.
        if (getX() < 0) {
            directMove(0, getY());
        }
        int width = Stage.WIDTH - getWidth();
        if (getX() > width) {
            directMove(width, getY());
        }
        if (getY() < 0) {
            directMove(getX(), 0);
        }
        int height = Stage.HEIGHT - getHeight();
        if (getY() > height) {
            directMove(getX(), height);
        }
    }

    /**
     * 키보드로 비행기를 조정할 수 있도록 하는 keyAdapter
     *
     * @return keyAdapter
     */
    public KeyAdapter getKeyAdapter() {
        return new KeyAdapter() {
            /*  37=left
             *  38=right
             *  39=up
             *  40=down
             *
             *  90=z
             *  88=x
             *  67=c
             *
             *  32 = space
             */
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case 37:
                        if ((direction & WEST) == 0) {
                            direction += WEST;
                        }
                        break;
                    case 38:
                        if ((direction & NORTH) == 0) {
                            direction += NORTH;
                        }
                        break;
                    case 39:
                        if ((direction & EAST) == 0) {
                            direction += EAST;
                        }
                        break;
                    case 40:
                        if ((direction & SOUTH) == 0) {
                            direction += SOUTH;
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case 37:
                        if ((direction & WEST) > 0) {
                            direction -= WEST;
                        }
                        break;
                    case 38:
                        if ((direction & NORTH) > 0) {
                            direction -= NORTH;
                        }
                        break;
                    case 39:
                        if ((direction & EAST) > 0) {
                            direction -= EAST;
                        }
                        break;
                    case 40:
                        if ((direction & SOUTH) > 0) {
                            direction -= SOUTH;
                        }
                        break;
                }
            }
        };
    }
}
