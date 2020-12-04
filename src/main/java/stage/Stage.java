package stage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import unit.Unit;
import unit.plane.friendly.Friendly;
import util.TimeChecker;

@SuppressWarnings("serial")
public class Stage extends JPanel {
    private static final int UNIT_ARR_LENGTH = Unit.UNIT_ARR_LENGTH;
    private TimeChecker tc = new TimeChecker("drawer");

    private static BufferedImage BACK_GROUND_IMG;
    private int width;
    private int height;
    protected Friendly plane;
    public Unit[] unitArr = new Unit[UNIT_ARR_LENGTH];

    public Stage(int width, int height, Friendly plane) {
        this.width = width;
        this.height = height;
        this.plane = plane;
        InputStream in = getClass().getClassLoader().getResourceAsStream("img/background.png");
        try {
            BACK_GROUND_IMG = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        moveUnit(plane);
        moveUnit(unitArr);
        this.repaint();
    }

    private void moveUnit(Unit[] unitArr) {
        for (int i = 0; i < UNIT_ARR_LENGTH; i++) {
            Unit unit = unitArr[i];
            if (unit == null || unit.isDead()) {
                continue;
            }
            if (unit.getX() < 0 || unit.getX() > width) {
                unit.dead();
                continue;
            }
            if (unit.getY() < 0 || unit.getY() > height) {
                unit.dead();
                continue;
            }
            moveUnit(unit);
        }
    }

    private void moveUnit(Unit unit) {
        unit.move();
        if (unit.hasSubUnit()) {
            moveUnit(unit.getSubUnitArr());
        }
    }

    @Override
    public void paint(Graphics g) {
        tc.timeCheckerStart();

        BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = tempImg.createGraphics();
        g2d.drawImage(BACK_GROUND_IMG, 0, 0, width, height, 0, 0, BACK_GROUND_IMG.getWidth(), BACK_GROUND_IMG.getHeight(), null);

        drawUnit(g2d, plane);
        drawUnit(g2d, unitArr);
        g.drawImage(tempImg, 0, 0, null);

        tc.timeCheckerEnd();
    }

    private void drawUnit(Graphics2D g2d, Unit unit) {
        unit.draw(g2d);
        if (unit.hasSubUnit()) {
            drawUnit(g2d, unit.getSubUnitArr());
        }
    }

    private void drawUnit(Graphics2D g2d, Unit[] unitArr) {
        for (Unit unit : unitArr) {
            if (unit == null || unit.isDead()) {
                continue;
            }
            drawUnit(g2d, unit);
        }
    }
}
