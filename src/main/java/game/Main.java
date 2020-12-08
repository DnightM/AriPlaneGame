package game;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import game.stage.*;
import game.ui.Window;
import game.unit.plane.friendly.Friendly;
import game.util.TimeChecker;

public class Main {
    public static void main(String[] args) {
        try {
            Window win = new Window();

            Stage stage = new Stage4(win.panelWidth, win.panelHeight);
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
