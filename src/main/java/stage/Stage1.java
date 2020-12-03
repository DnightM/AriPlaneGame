package stage;

import unit.enemy.Enemy1;

@SuppressWarnings("serial")
public class Stage1 extends Stage {
    public Stage1(int width, int height) {
        super(width, height);
    }

    public void init() {
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
