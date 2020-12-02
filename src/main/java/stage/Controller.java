package stage;

import ui.BackgroundPanel;
import unit.Unit;
import unit.enemy.Enemy1;

@SuppressWarnings("serial")
public class Controller extends BackgroundPanel {

    public Controller(int width, int height) {
        super(width, height);
    }

    public void init() {
        Enemy1 e1 = new Enemy1(100, 100);
        unitList.add(e1);
    }

    public void run() {
        for (int i = 0; i < unitList.size(); i++) {
            Unit unit = unitList.get(i);
            unit.move();
        }
        this.repaint();
    }
}
