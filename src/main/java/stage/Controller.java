package stage;

import java.util.Arrays;

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
        long before = 0;
        long time = 0;
        int count = 0;
        while (true) {
            before = time;
            time = System.currentTimeMillis() / 1000;
            try {
                Thread.sleep(5);
                for (int i = 0; i < unitList.size(); i++) {
                    Unit unit = unitList.get(i);
                    unit.move();
                }
                this.repaint();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time != before) {
                System.out.println(time);
                System.out.println(count);
                count = 0;
            }
        }
    }
}
