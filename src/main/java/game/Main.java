package game;

import game.stage.*;
import game.ui.Window;

public class Main {
    public static void main(String[] args) {
        try {
            Window win = new Window();

            Stage stage = new StageTest(win.panelWidth, win.panelHeight);
            stage.init();

            win.setPanel(stage);
            win.addKeyListener(stage.getKeyAdapter());

            stage.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
