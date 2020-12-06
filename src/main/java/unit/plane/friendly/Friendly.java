package unit.plane.friendly;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import unit.Unit;
import unit.plane.Plane;

public abstract class Friendly extends Plane {
    public int direction = Unit.STAY;

    public abstract void setBulletName(String bulletName);

    public Friendly(int x, int y) {
        super(x, y, Unit.STAY);
    }

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
