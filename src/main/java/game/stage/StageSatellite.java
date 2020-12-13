package game.stage;

import game.Point;
import game.scenario.ScenarioBreak;
import game.scenario.ScenarioStraight;
import game.unit.plane.enemy.EnemyStraight;
import game.unit.plane.enemy.EnemySpread;
import game.unit.plane.friendly.Friendly;
import game.unit.plane.friendly.FriendlyGuided;
import game.unit.plane.friendly.FriendlyStraight;
import game.unit.plane.friendly.satellite.SatelliteLeft;
import game.unit.plane.friendly.satellite.SatelliteRight;

@SuppressWarnings("serial")
public class StageSatellite extends Stage {
    public StageSatellite(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new FriendlyGuided(new Point(WIDTH / 2 + Friendly.WIDTH / 2, HEIGHT -100));
        friendlyArr[1] = new SatelliteLeft(friendlyArr[0]);
        friendlyArr[2] = new SatelliteRight(friendlyArr[0]);

        for (int i = 0; i < 10; i++) {
            EnemyStraight e = new EnemyStraight(new ScenarioStraight(0L, 100 * i));
            enemyArr[i] = e;
        }
        for (int i = 10; i < 20; i++) {
            EnemySpread e = new EnemySpread(new ScenarioBreak(0L, 100 * (i - 10) + 50, 500, (i & 1) > 0));
            enemyArr[i] = e;
        }
    }
}
