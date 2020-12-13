package game.ui;

import game.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Window extends JFrame {
    public int panelWidth;
    public int panelHeight;

    public Window() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        int height = 1000;
        int width = height * 9 / 16;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        Insets i = this.getInsets();

        this.panelWidth = width - i.left - i.right;
        this.panelHeight = height - i.top - i.bottom;
    }

    public void setPanel(Stage b) {
        this.getContentPane().removeAll();
        this.add(b);
        this.validate();
    }
}
