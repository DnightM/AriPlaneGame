package game;

import game.stage.*;
import game.ui.Window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        try {
            Window win = new Window();

            Stage stage = new Stage5(win.panelWidth, win.panelHeight);
            stage.init();

            win.setPanel(stage);
            win.addKeyListener(stage.getKeyAdapter());
            win.addKeyListener(stage.getOptionKeyAdapter());
            stage.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
