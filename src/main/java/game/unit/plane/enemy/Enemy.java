package game.unit.plane.enemy;

import game.scenario.Scenario;
import game.stage.Stage;
import game.unit.plane.Plane;

public abstract class Enemy extends Plane {
    private final Scenario sc;

    public Enemy(Scenario sc, double direction) {
        super(sc.getStartPos(), direction);
        this.sc = sc;
    }

    @Override
    public void move() {
        double[] sw = sc.move(pos);
        super.directMove(sw[0] * speed(), sw[1] * speed());
        if (getX() > Stage.WIDTH || getX() < 0) {
            kill();
        }
        if (getY() > Stage.HEIGHT) {
            kill();
        }
        shotBullet();
    }
}
