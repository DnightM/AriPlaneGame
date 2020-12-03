package main;

import stage.Stage;
import stage.Stage1;
import ui.Window;
import unit.plane.FirstPlane;

public class Main {
    public static void main(String[] args) {
        Window win = new Window();
        Stage1 con = new Stage1(win.panelWidth, win.panelHeight);
        con.init();
        FirstPlane p = new FirstPlane(500, 900);
        con.unitList.add(p);
        win.setPanel(con);
        win.addKeyListener(p.getKeyAdapter());
        run(con);
    }

    private static void run(Stage con) {
        int sleep = 5;
        long time = System.currentTimeMillis() / 1000;

        long before = 0;
        int count = 0;
        while (true) {
            before = time;
            time = System.currentTimeMillis() / 1000;
            try {
                Thread.sleep(sleep);
                con.run();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time != before) {
                System.out.println("sleep:" + sleep + "ms | time:" + time + " | " + "frame:" + count);
                count = 0;
            }
        }
    }
}
