package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import unit.Unit;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {
    private static BufferedImage BACK_GROUND_IMG;
    private int width;
    private int height;
    protected ArrayList<Unit> unitList = new ArrayList<>();

    public BackgroundPanel(int width, int height) {
        this.width = width;
        this.height = height;
        InputStream in = getClass().getClassLoader().getResourceAsStream("img/background.png");
        try {
            BACK_GROUND_IMG = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = tempImg.createGraphics();
        g2d.drawImage(BACK_GROUND_IMG, 0, 0, width, height, 0, 0, BACK_GROUND_IMG.getWidth(), BACK_GROUND_IMG.getHeight(), null);

        int len = unitList.size();
        for (int i = 0; i < len; i++) {
            Unit unit = unitList.get(i);
            unit.draw(g2d);
        }
        g.drawImage(tempImg, 0, 0, null);
    }
}
