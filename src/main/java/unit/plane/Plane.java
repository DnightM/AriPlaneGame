package unit.plane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import unit.Unit;
import unit.bullet.Bullet;

public abstract class Plane extends Unit {
    public static int DIRECTION = Unit.STAY;

    public abstract Bullet setBullet(Bullet bullet);

    public abstract Bullet getBullet();

    public Plane(int x, int y, double speed) {
        super(x, y, Unit.STAY, speed);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this.bulletTimerThread(), 0, getBullet().getRate(), TimeUnit.MILLISECONDS);
    }

    public Runnable bulletTimerThread() {
        return () -> {
            Bullet bullet = getBullet();
            
        };
    }

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
                    if ((DIRECTION & Unit.WEST) == 0) {
                        DIRECTION += Unit.WEST;
                        setDirection(DIRECTION);
                    }
                    break;
                case 38:
                    if ((DIRECTION & Unit.NORTH) == 0) {
                        DIRECTION += Unit.NORTH;
                        setDirection(DIRECTION);
                    }
                    break;
                case 39:
                    if ((DIRECTION & Unit.EAST) == 0) {
                        DIRECTION += Unit.EAST;
                        setDirection(DIRECTION);
                    }
                    break;
                case 40:
                    if ((DIRECTION & Unit.SOUTH) == 0) {
                        DIRECTION += Unit.SOUTH;
                        setDirection(DIRECTION);
                    }
                    break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                case 37:
                    if ((DIRECTION & Unit.WEST) > 0) {
                        DIRECTION -= Unit.WEST;
                        setDirection(DIRECTION);
                    }
                    break;
                case 38:
                    if ((DIRECTION & Unit.NORTH) > 0) {
                        DIRECTION -= Unit.NORTH;
                        setDirection(DIRECTION);
                    }
                    break;
                case 39:
                    if ((DIRECTION & Unit.EAST) > 0) {
                        DIRECTION -= Unit.EAST;
                        setDirection(DIRECTION);
                    }
                    break;
                case 40:
                    if ((DIRECTION & Unit.SOUTH) > 0) {
                        DIRECTION -= Unit.SOUTH;
                        setDirection(DIRECTION);
                    }
                    break;
                }
            }

        };
    }
}
