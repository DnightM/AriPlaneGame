package game.stage;

import game.Point;
import game.scenario.ScenarioStraight;
import game.unit.plane.enemy.EnemyStraight;
import game.unit.plane.friendly.Friendly;
import game.unit.plane.friendly.FriendlyGuided;
import game.unit.plane.friendly.FriendlyStraight;

@SuppressWarnings("serial")
public class StageStraight extends Stage {
    public StageStraight(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new FriendlyStraight(new Point((double) WIDTH / 2 + (double) Friendly.WIDTH / 2, HEIGHT - 100));
        for (int i = 0; i < 10; i++) {
            EnemyStraight e = new EnemyStraight(new ScenarioStraight(i * 10, WIDTH / 10 * (i % 10)));
            enemyArr[i] = e;
        }
    }
}
