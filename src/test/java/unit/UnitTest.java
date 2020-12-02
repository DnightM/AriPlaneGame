package unit;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics;

import org.junit.Test;

public class UnitTest {
    private int x = 100;
    private int y = 100;

    @Test
    public void moveTest1() {
        Unit u = new Unit(x, y, Unit.WEST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getX(), 90);
    }

    @Test
    public void moveTest2() {
        Unit u = new Unit(x, y, Unit.NORTH, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getY(), 90);
    }

    @Test
    public void moveTest3() {
        Unit u = new Unit(x, y, Unit.EAST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getX(), 110);
    }

    @Test
    public void moveTest4() {
        Unit u = new Unit(x, y, Unit.SOUTH, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getY(), 110);
    }

    @Test
    public void moveTest5() {
        Unit u = new Unit(x, y, Unit.NORTH_WEST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getX(), calDiagonal(x, -10));
        assertEquals(u.getY(), calDiagonal(x, -10));
    }

    @Test
    public void moveTest6() {
        Unit u = new Unit(x, y, Unit.SOUTH_WEST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getX(), calDiagonal(x, -10));
        assertEquals(u.getY(), calDiagonal(x, 10));
    }

    @Test
    public void moveTest7() {
        Unit u = new Unit(x, y, Unit.NORTH_EAST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getX(), calDiagonal(x, 10));
        assertEquals(u.getY(), calDiagonal(x, -10));
    }

    @Test
    public void moveTest8() {
        Unit u = new Unit(x, y, Unit.SOUTH_EAST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 100; i++) {
            u.move();
        }
        assertEquals(u.getX(), calDiagonal(x, 10));
        assertEquals(u.getY(), calDiagonal(x, 10));
    }

    @Test
    public void moveTest9() {
        Unit u = new Unit(x, y, Unit.SOUTH_EAST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 1000; i++) {
            u.move();
        }
        u.setDirection(Unit.NORTH_WEST);
        for (int i = 0; i < 1000; i++) {
            u.move();
        }
        assertEquals(u.getX(), 100);
        assertEquals(u.getY(), 100);
    }

    @Test
    public void moveTest10() {
        Unit u = new Unit(x, y, Unit.SOUTH_WEST, 0.1d) {
            @Override
            public void draw(Graphics g) {
            }
        };
        for (int i = 0; i < 1000; i++) {
            u.move();
        }
        u.setDirection(Unit.NORTH_EAST);
        for (int i = 0; i < 1000; i++) {
            u.move();
        }
        assertEquals(u.getX(), 100);
        assertEquals(u.getY(), 100);
    }

    public int calDiagonal(double pos, int speed) {
        double p = 1 / Math.sqrt(2);
        pos += speed * p;
        return (int) Math.round(pos);
    }
}
