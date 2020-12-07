package main;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import stage.Stage;
import stage.Stage3;
import ui.Window;
import unit.plane.friendly.Friendly;
import util.TimeChecker;

public class Main {
    public static void main(String[] args) {
        try {
            Window win = new Window();

            Stage stage = new Stage3(win.panelWidth, win.panelHeight);
            stage.init();

            win.setPanel(stage);
            for (Friendly friendly : stage.getFriendlyArr()) {
                if (friendly == null) {
                    break;
                }
                win.addKeyListener(friendly.getKeyAdapter());
            }

            run(stage);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
