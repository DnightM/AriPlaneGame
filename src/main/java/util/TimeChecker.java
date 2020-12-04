package util;

public class TimeChecker {
    private long time = 0, count = 0, calcuratorTime = 0, before;
    private String name;

    public TimeChecker(String name) {
        this.name = name;
    }

    public void timeCheckerEnd() {
        calcuratorTime += System.currentTimeMillis() - time;
        if (time / 1000 != before) {
            System.out.println(name + " | time:" + time + " | " + "frame:" + count + " | calcuratorTime: " + calcuratorTime);
            count = 0;
            calcuratorTime = 0;
        }
    }

    public void timeCheckerStart() {
        before = time / 1000;
        time = System.currentTimeMillis();
        count++;
    }
}
