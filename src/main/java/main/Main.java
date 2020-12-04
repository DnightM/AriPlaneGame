package main;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import stage.Stage;
import stage.Stage1;
import ui.Window;
import unit.plane.friendly.Friendly1;
import util.TimeChecker;

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

    private static void run(Stage stage) {
        TimeChecker tc = new TimeChecker("worker");
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(() -> {
            tc.timeCheckerStart();

            stage.run();

            tc.timeCheckerEnd();
        }, 0, 1000 / 120, TimeUnit.MILLISECONDS);
    }

}
