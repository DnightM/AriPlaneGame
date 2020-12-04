package main;

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

        try {
            run(stage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void run(Stage stage) throws InterruptedException {
        int sleep = 5;

        while (true) {
            Thread.sleep(sleep);
            stage.run();
        }
    }
}
