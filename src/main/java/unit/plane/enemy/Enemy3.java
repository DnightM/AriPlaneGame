package unit.plane.enemy;

import java.awt.image.BufferedImage;

public class Enemy3 extends Enemy {
    public Enemy3(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public String getBulletName() {
        return null;
    }

    @Override
    protected int maxLife() {
        return 10;
    }

    @Override
    protected double speed() {
        return 0;
    }

    @Override
    protected BufferedImage img() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

}
