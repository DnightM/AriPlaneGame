package game.stage;

import game.Point;
import game.scenario.Scenario;
import game.unit.plane.enemy.*;
import game.unit.plane.friendly.*;

@SuppressWarnings("serial")
public class Stage5 extends Stage {
    public Stage5(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        for (int i = 0; i < 1; i += 2) {
            Enemy e = new Enemy1(new Scenario(100));
            Enemy e1 = new Enemy2(new Scenario(0));
            enemyArr[i] = e;
            enemyArr[i + 1] = e1;
        }
    }
}
