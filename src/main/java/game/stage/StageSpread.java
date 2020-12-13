package game.stage;

import game.Point;
import game.scenario.*;
import game.unit.plane.enemy.*;
import game.unit.plane.friendly.*;

@SuppressWarnings("serial")
public class StageSpread extends Stage {
    public StageSpread(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new FriendlySpread(new Point(WIDTH / 2 + Friendly.WIDTH / 2, HEIGHT -100));
        for (int i = 0; i < 10; i++) {
            Enemy e = new EnemySpread(new ScenarioBreak(0L, 100 * i, 500, (i & 1) > 0));
            enemyArr[i] = e;
        }
    }
}
