package game.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeChecker {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private long time = 0, count = 0, calcuratorTime = 0, before;
    private final String name;

    public TimeChecker(String name) {
        this.name = name;
    }

    public void timeCheckerEnd() {
        calcuratorTime += System.currentTimeMillis() - time;
        if (time / 1000 != before) {
            String msg = String.format("%s | millis:%d | frame:% 4d | calTime:% 5d", name, time, count, calcuratorTime);
            logger.info(msg);
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
