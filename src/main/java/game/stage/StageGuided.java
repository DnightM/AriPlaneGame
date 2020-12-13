package game.stage;

import game.Point;
import game.scenario.ScenarioStraight;
import game.unit.plane.enemy.EnemyGuided;
import game.unit.plane.enemy.EnemyStraight;
import game.unit.plane.friendly.Friendly;
import game.unit.plane.friendly.FriendlyGuided;

@SuppressWarnings("serial")
public class StageGuided extends Stage {
    public StageGuided(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new FriendlyGuided(new Point((double)WIDTH / 2 + (double)Friendly.WIDTH / 2, HEIGHT -100));
        for (int i = 0; i < 10; i++) {
            EnemyGuided e = new EnemyGuided(new ScenarioStraight(0L, 100 * i));
            enemyArr[i] = e;
        }
    }
}
