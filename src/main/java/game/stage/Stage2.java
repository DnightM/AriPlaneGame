package game.stage;

import game.Point;
import game.scenario.ScenarioBreak;
import game.unit.plane.enemy.Enemy1;
import game.unit.plane.friendly.Friendly1;

@SuppressWarnings("serial")
public class Stage2 extends Stage {
    public Stage2(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        for (int i = 0; i < 10; i++) {
            Enemy1 e = new Enemy1(new ScenarioBreak(0L, 100 * i, 500, (i & 1) > 0));
            enemyArr[i] = e;
        }
    }
}
