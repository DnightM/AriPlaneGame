package unit.plane.friendly;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import stage.Stage;
import unit.Unit;
import unit.plane.Plane;

public abstract class Friendly extends Plane {
    private static final Logger logger = LoggerFactory.getLogger(Friendly.class);

    public int direction = Unit.STAY;

    public abstract void setBulletNames(String[] bulletNames);

    public Friendly(int x, int y) {
        super(x, y, Unit.STAY);
    }

    @Override
    public void dead() {
        super.dead();
        logger.info("friendly dead");
    }

    @Override
    public void move() {
        super.move();

        // 아래 if 4개는 stage에서 정의된 width height 범위를 비행기가 넘어가지 못하도록 제한하는 역할을 함.
        if (getX() < 0) {
            setX(0);
        }
        int width = Stage.WIDTH - getWidth();
        if (getX() > width) {
            setX(width);
        }
        if (getY() < 0) {
            setY(0);
        }
        int height = Stage.HEIGHT - getHeight();
        if (getY() > height) {
            setY(height);
        }
    }

    /**
     * 키보드로 비행기를 조정할 수 있도록 하는 keyAdapter
     * @return
     */
    public final KeyAdapter getKeyAdapter() {
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
                    if ((direction & Unit.WEST) == 0) {
                        direction += Unit.WEST;
                        setDirection(direction);
                    }
                    break;
                case 38:
                    if ((direction & Unit.NORTH) == 0) {
                        direction += Unit.NORTH;
                        setDirection(direction);
                    }
                    break;
                case 39:
                    if ((direction & Unit.EAST) == 0) {
                        direction += Unit.EAST;
                        setDirection(direction);
                    }
                    break;
                case 40:
                    if ((direction & Unit.SOUTH) == 0) {
                        direction += Unit.SOUTH;
                        setDirection(direction);
                    }
                    break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                case 37:
                    if ((direction & Unit.WEST) > 0) {
                        direction -= Unit.WEST;
                        setDirection(direction);
                    }
                    break;
                case 38:
                    if ((direction & Unit.NORTH) > 0) {
                        direction -= Unit.NORTH;
                        setDirection(direction);
                    }
                    break;
                case 39:
                    if ((direction & Unit.EAST) > 0) {
                        direction -= Unit.EAST;
                        setDirection(direction);
                    }
                    break;
                case 40:
                    if ((direction & Unit.SOUTH) > 0) {
                        direction -= Unit.SOUTH;
                        setDirection(direction);
                    }
                    break;
                }
            }
        };
    }
}
