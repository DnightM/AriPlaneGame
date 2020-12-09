package game.stage;

import game.Point;
import game.scenario.ScenarioStraight;
import game.unit.plane.enemy.Enemy1;
import game.unit.plane.friendly.Friendly2;

@SuppressWarnings("serial")
public class Stage3 extends Stage {
    public Stage3(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly2(new Point(500, 900));

        for (int i = 0; i < 10; i++) {
            Enemy1 e = new Enemy1(new ScenarioStraight(0L, 100 * i));
            enemyArr[i] = e;
        }
    }
}
