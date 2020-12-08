package util;

public class TimeThread extends Thread {
    private final long millis;

    public TimeThread(Runnable run, long millis) {
        super(run);
        this.millis = millis;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
