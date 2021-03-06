package game.unit.plane.enemy;

import java.awt.image.BufferedImage;

import game.scenario.Scenario;
import game.unit.Unit;

public class EnemyGuided extends Enemy {
    private static final BufferedImage IMG = getImg("img/enemy/enemy1.png");

    public EnemyGuided(Scenario sc) {
        super(sc, Unit.STAY);
    }

    @Override
    protected BufferedImage img() {
        return IMG;
    }

    @Override
    public int getWidth() {
        return 20;
    }

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    protected double speed() {
        return 0.3d;
    }

    @Override
    public String[] getBulletNames() {
        return new String[] { "EnemyGuidedBullet" };
    }

    @Override
    protected int maxLife() {
        return 10;
    }
}
