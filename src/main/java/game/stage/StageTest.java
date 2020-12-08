package game.stage;

import game.Point;
import game.unit.plane.enemy.Enemy;
import game.unit.plane.enemy.Enemy1;
import game.unit.plane.friendly.Friendly2;
import game.unit.plane.friendly.satellite.SatelliteLeft;
import game.unit.plane.friendly.satellite.SatelliteRight;

@SuppressWarnings("serial")
public class StageTest extends Stage {
    public StageTest(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly2(new Point(500, 900));
        friendlyArr[1] = new SatelliteLeft(new Point(500, 900), friendlyArr[0]);
        friendlyArr[2] = new SatelliteRight(new Point(500, 900), friendlyArr[0]);
        for (int i = 0; i < 1; i++) {
            Enemy e = new Enemy1(new Point(500, 200));
            enemyArr[i] = e;
        }
    }
}
