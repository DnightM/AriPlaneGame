package stage;

import unit.plane.enemy.Enemy2;
import unit.plane.friendly.Friendly;

@SuppressWarnings("serial")
public class Stage1 extends Stage {
    public Stage1(int width, int height, Friendly[] plane) {
        super(width, height, plane);
    }

    public void init() {
        //        for (int i = 0; i < 10; i++) {
        //            Enemy1 e = new Enemy1(100 * i, 100);
        //            enemyArr[i] = e;
        //        }
        for (int i = 0; i < 1; i++) {
            Enemy2 e = new Enemy2(400, 100);
            enemyArr[i] = e;
        }
    }
}
