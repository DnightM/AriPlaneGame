package game.stage;

import game.Point;
import game.scenario.ScenarioStraight;
import game.unit.plane.enemy.Enemy1;
import game.unit.plane.friendly.Friendly1;

@SuppressWarnings("serial")
public class Stage1 extends Stage {
    public Stage1(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        for (int i = 0; i < 100; i++) {
            Enemy1 e = new Enemy1(new ScenarioStraight(i * 10, 100 * (i % 10)));
            enemyArr[i] = e;
        }
    }
}
