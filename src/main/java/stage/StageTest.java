package stage;

import unit.plane.enemy.Enemy;
import unit.plane.enemy.Enemy1;
import unit.plane.friendly.Friendly2;

@SuppressWarnings("serial")
public class StageTest extends Stage {
    public StageTest(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly2(500, 900);

        for (int i = 0; i < 1; i++) {
            Enemy e = new Enemy1(500, 200);
            enemyArr[i] = e;
        }
    }
}
