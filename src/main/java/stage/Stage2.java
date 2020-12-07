package stage;

import unit.plane.enemy.Enemy2;
import unit.plane.friendly.Friendly1;

@SuppressWarnings("serial")
public class Stage2 extends Stage {
    public Stage2(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(500, 900);
        
        for (int i = 0; i < 5; i++) {
            Enemy2 e = new Enemy2(200 * i, 100);
            enemyArr[i] = e;
        }
    }
}
