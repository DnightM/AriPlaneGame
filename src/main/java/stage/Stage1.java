package stage;

import unit.plane.enemy.Enemy1;
import unit.plane.friendly.Friendly;

@SuppressWarnings("serial")
public class Stage1 extends Stage {
    public Stage1(int width, int height, Friendly plane) {
        super(width, height, plane);
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            Enemy1 e1 = new Enemy1(100, 100);
            unitList.add(e1);
            Enemy1 e2 = new Enemy1(200, 100);
            unitList.add(e2);
            Enemy1 e3 = new Enemy1(300, 100);
            unitList.add(e3);
            Enemy1 e4 = new Enemy1(400, 100);
            unitList.add(e4);
            Enemy1 e5 = new Enemy1(500, 100);
            unitList.add(e5);
        }
    }
}
