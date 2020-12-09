package game.stage;

import game.Point;
import game.scenario.Scenario;
import game.unit.plane.enemy.*;
import game.unit.plane.friendly.*;

@SuppressWarnings("serial")
public class StageTest extends Stage {
    public StageTest(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        Enemy e = new Enemy3(new Scenario(0));
        Enemy e1 = new Enemy3(new Scenario(0));
        enemyArr[0] = e;
        enemyArr[1] = e1;
    }
}
