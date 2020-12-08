package game.ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import game.stage.Stage;

@SuppressWarnings("serial")
public class Window extends JFrame {
    private Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
    public int panelWidth;
    public int panelHeight;

    public Window() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        int width = 1000;
        int height = 1000;
        this.setBounds(dimen.width / 2 - width / 2, dimen.height / 2 - height / 2, width, height);
        this.setTitle("뷍");

        this.setVisible(true);
        Insets i = this.getInsets();

        this.panelWidth = 1000 - i.left - i.right;
        this.panelHeight = 1000 - i.top - i.bottom;
    }

    public void setPanel(Stage b) {
        this.getContentPane().removeAll();
        this.add(b);
        this.validate();
    }
}
