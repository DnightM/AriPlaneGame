package game;

import game.stage.*;
import game.ui.Window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        try {
            Window win = new Window();

//            Stage stage = new StageGuided(win.panelWidth, win.panelHeight);
//            Stage stage = new StageSatellite(win.panelWidth, win.panelHeight);
//            Stage stage = new StageSpread(win.panelWidth, win.panelHeight);
            Stage stage = new StageStraight(win.panelWidth, win.panelHeight);
//            Stage stage = new StageSingle(win.panelWidth, win.panelHeight);
            stage.init();

            win.setTitle("비행기 게임 " + stage.getClass().getSimpleName());
            win.setPanel(stage);
            win.addKeyListener(stage.getKeyAdapter());
            win.addKeyListener(stage.getOptionKeyAdapter());
            stage.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
