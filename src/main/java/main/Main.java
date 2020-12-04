package main;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import stage.Stage;
import stage.Stage1;
import ui.Window;
import unit.plane.friendly.Friendly1;

public class Main {
    public static void main(String[] args) {
        Window win = new Window();
        Friendly1 p = new Friendly1(500, 900);
        Stage1 stage = new Stage1(win.panelWidth, win.panelHeight, p);
        stage.init();
        win.setPanel(stage);
        win.addKeyListener(p.getKeyAdapter());

        run(stage);
    }

    static long time = 0, count = 0, calcuratorTime = 0;

    private static void run(Stage stage) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(() -> {
            long before = time / 1000;
            time = System.currentTimeMillis();
            count++;

            stage.run();
            calcuratorTime += System.currentTimeMillis() - time;
            if (time / 1000 != before) {
                System.out.println("worker | time:" + time + " | " + "frame:" + count + " | calcuratorTime: " + calcuratorTime);
                count = 0;
                calcuratorTime = 0;
            }
        }, 0, 1000 / 120, TimeUnit.MILLISECONDS);
    }
}
