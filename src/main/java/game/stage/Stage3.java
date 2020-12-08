package game.stage;

import game.Point;
import game.unit.plane.enemy.Enemy;
import game.unit.plane.enemy.Enemy1;
import game.unit.plane.enemy.Enemy2;
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
            Enemy e = new Enemy2(new Point(100 * i, 100));
            enemyArr[i] = e;
        }
        for (int i = 10; i < 20; i++) {
            Enemy e = new Enemy1(new Point(100 * (i - 10) + 50, 200));
            enemyArr[i] = e;
        }
    }
}
