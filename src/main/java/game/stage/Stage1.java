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
        // 10개가 직선으로 다가오면서 총알 쏘면 됨
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        for (int i = 0; i < 10; i++) {
            Enemy1 e = new Enemy1(new ScenarioStraight(0L, 100 * i));
            enemyArr[i] = e;
        }
    }
}
