package stage;

import unit.plane.enemy.Enemy1;
import unit.plane.friendly.Friendly;

@SuppressWarnings("serial")
public class Stage1 extends Stage {
    public Stage1(int width, int height, Friendly plane) {
        super(width, height, plane);
    }

    public void init() {
        for (int i = 0; i < 20; i++) {
            Enemy1 e1 = new Enemy1(50 * i + 100, 100);
            unitArr[i] = e1;
        }
    }
}
