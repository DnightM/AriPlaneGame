package stage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import unit.Unit;
import unit.plane.friendly.Friendly;

@SuppressWarnings("serial")
public class Stage extends JPanel {
    private static BufferedImage BACK_GROUND_IMG;
    private int width;
    private int height;
    protected Friendly plane;
    public ArrayList<Unit> unitList = new ArrayList<>();

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
        moveUnit(unitList);
        this.repaint();
    }

    private void moveUnit(ArrayList<Unit> unitList) {
        Iterator<Unit> iter = unitList.iterator();
        while (iter.hasNext()) {
            Unit unit = iter.next();
            if (unit.getX() < 0 || unit.getX() > width) {
                iter.remove();
                continue;
            }
            if (unit.getY() < 0 || unit.getY() > height) {
                iter.remove();
                continue;
            }
            moveUnit(unit);
        }
    }

    private void moveUnit(Unit unit) {
        unit.move();
        if (unit.hasSubUnit()) {
            moveUnit(unit.getSubUnitList());
        }
    }

    long time = 0, count = 0;

    @Override
    public void paint(Graphics g) {
        long before = time;
        time = System.currentTimeMillis() / 1000;
        count++;
        BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = tempImg.createGraphics();
        g2d.drawImage(BACK_GROUND_IMG, 0, 0, width, height, 0, 0, BACK_GROUND_IMG.getWidth(), BACK_GROUND_IMG.getHeight(), null);

        drawUnit(g2d, plane);
        drawUnit(g2d, unitList);
        g.drawImage(tempImg, 0, 0, null);
        if (time != before) {
            System.out.println("time:" + time + " | " + "frame:" + count);
            count = 0;
        }
    }

    private void drawUnit(Graphics2D g2d, Unit unit) {
        unit.draw(g2d);
        if (unit.hasSubUnit()) {
            drawUnit(g2d, unit.getSubUnitList());
        }
    }

    private void drawUnit(Graphics2D g2d, ArrayList<Unit> unitList) {
        Iterator<Unit> iter = unitList.iterator();
        while (iter.hasNext()) {
            Unit unit = iter.next();
            drawUnit(g2d, unit);
        }
    }
}
