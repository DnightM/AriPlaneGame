package game.unit.plane.enemy;

import java.awt.image.BufferedImage;

import game.scenario.Scenario;
import game.unit.Unit;

public class Enemy3 extends Enemy {
    private static final BufferedImage IMG = getImg("img/enemy/enemy1.png");

    public Enemy3(Scenario sc) {
        super(sc, Unit.STAY);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public int getWidth() {
        return 100;
    }

    @Override
    public int getHeight() {
        return 100;
    }

    @Override
    protected double speed() {
        return 0.3d;
    }

    @Override
    public String[] getBulletNames() {
        return new String[] { "EnemyStraightBullet" };
    }

    @Override
    protected int maxLife() {
        return 1000;
    }
}
