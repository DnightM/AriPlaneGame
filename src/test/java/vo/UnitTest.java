package vo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {
    @Before
    public void init() {

    }

    @Test
    public void moveTest() {
        Unit u = new Unit() {
        };
        u.x = 100;
        u.y = 100;
        u.direction = 1;
        u.speed = 0.5;
        u.move();

        assertEquals(u.getX(), 100);
    }
}
