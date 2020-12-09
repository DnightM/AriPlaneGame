package game.stage;

import game.Point;
import game.scenario.ScenarioBreak;
import game.scenario.ScenarioStraight;
import game.unit.plane.enemy.Enemy1;
import game.unit.plane.enemy.Enemy2;
import game.unit.plane.friendly.Friendly1;
import game.unit.plane.friendly.satellite.SatelliteLeft;
import game.unit.plane.friendly.satellite.SatelliteRight;

@SuppressWarnings("serial")
public class Stage4 extends Stage {
    public Stage4(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        friendlyArr[1] = new SatelliteLeft(new Point(500, 900), friendlyArr[0]);
        friendlyArr[2] = new SatelliteRight(new Point(500, 900), friendlyArr[0]);

        for (int i = 0; i < 10; i++) {
            Enemy1 e = new Enemy1(new ScenarioStraight(0L, 100 * i));
            enemyArr[i] = e;
        }
        for (int i = 10; i < 20; i++) {
            Enemy2 e = new Enemy2(new ScenarioBreak(0L, 100 * (i - 10) + 50, 500, (i & 1) > 0));
            enemyArr[i] = e;
        }
    }
}
