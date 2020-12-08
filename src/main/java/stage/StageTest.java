package stage;

import unit.plane.enemy.Enemy;
import unit.plane.enemy.Enemy1;
import unit.plane.friendly.Friendly2;
import unit.plane.friendly.satellite.SatelliteLeft;
import unit.plane.friendly.satellite.SatelliteRight;

@SuppressWarnings("serial")
public class StageTest extends Stage {
    public StageTest(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly2(500, 900);
        friendlyArr[1] = new SatelliteLeft(500, 900, friendlyArr[0]);
        friendlyArr[2] = new SatelliteRight(500, 900, friendlyArr[0]);
        for (int i = 0; i < 1; i++) {
            Enemy e = new Enemy1(500, 200);
            enemyArr[i] = e;
        }
    }
}
