package game.scenario;

import java.util.Timer;
import java.util.TimerTask;

public class Scenario extends TimerTask {
    private boolean isDelayDone = false;
    
    public Scenario(long delay) {
        Timer t = new Timer();
        t.schedule(this, delay);
    }

    public boolean isDelayDone() {
        return isDelayDone;
    }

    @Override
    public void run() {
        isDelayDone = true;
    }
}
