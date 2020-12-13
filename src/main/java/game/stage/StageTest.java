package game.stage;

import game.Point;
import game.scenario.*;
import game.unit.plane.enemy.*;
import game.unit.plane.friendly.*;

@SuppressWarnings("serial")
public class StageTest extends Stage {
    public StageTest(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new FriendlyGuided(new Point((double) WIDTH / 2 + (double) Friendly.WIDTH / 2, (double) HEIGHT - 100));
        for (int i = 0; i < 10; i++) {
            EnemyStraight e = new EnemyStraight(new ScenarioStop(i * 10, WIDTH / 10 * (i % 10), 100));
            enemyArr[i] = e;
        }
    }
}
