package game.stage;

import game.Point;
import game.scenario.*;
import game.unit.plane.enemy.*;
import game.unit.plane.friendly.*;

@SuppressWarnings("serial")
public class Stage2 extends Stage {
    public Stage2(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        for (int i = 0; i < 10; i++) {
            Enemy e = new Enemy2(new ScenarioBreak(0L, 100 * i, 500, (i & 1) > 0));
            enemyArr[i] = e;
        }
    }
}
