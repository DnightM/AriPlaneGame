package stage;

import unit.plane.enemy.Enemy1;
import unit.plane.friendly.Friendly1;

@SuppressWarnings("serial")
public class Stage1 extends Stage {
    public Stage1(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(500, 900);

        for (int i = 0; i < 20; i++) {
            Enemy1 e = new Enemy1(50 * i, 100);
            enemyArr[i] = e;
        }
    }
}
