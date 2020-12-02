package plane;

import stage.Controller;
import ui.Window;

public class Main {
    public static void main(String[] args) {
        Window win = new Window();
        Controller con = new Controller(win.panelWidth, win.panelHeight);
        con.init();
        win.setPanel(con);
        con.run();
    }
}
