package stage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import unit.Unit;
import unit.bullet.Bullet;
import unit.plane.Plane;
import unit.plane.enemy.Enemy;
import unit.plane.friendly.Friendly;
import util.TimeChecker;

@SuppressWarnings("serial")
public class Stage extends JPanel {
    private static final int UNIT_ARR_LENGTH = Unit.UNIT_ARR_LENGTH;
    private TimeChecker tc = new TimeChecker("drawer");

    private static BufferedImage BACK_GROUND_IMG;
    private int width;
    private int height;
    protected Friendly[] friendlyArr;
    public Enemy[] enemyArr;

    public Stage(int width, int height, Friendly[] friendlyArr) {
        this.width = width;
        this.height = height;
        this.friendlyArr = friendlyArr;
        this.enemyArr = new Enemy[UNIT_ARR_LENGTH];
        try {
            BACK_GROUND_IMG = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            moveUnit(friendlyArr, enemyArr);
            moveUnit(enemyArr, friendlyArr);
            this.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void moveUnit(Unit[] unitArr, Plane[] opponentArr) {
        for (Unit unit : unitArr) {
            if (unit == null) {
                break;
            }
            if (unit.isDead()) {
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
            unit.move();
            checkCollision(unit, opponentArr); // 충돌검사
            if (unit.hasSubUnit()) {
                moveUnit(unit.getSubUnitArr(), opponentArr);
            }
        }
    }

    /**
     * 경우의수3
     * 1. 아군기 : 적군기 , 적군기 : 아군기
     *      -> 아군기 및 적군기 dead. 라이프 상관x
     * 2. 아군기 : 적군총알
     *      -> 아군기 체력 감소. 적군 총알 dead
     * 3. 적군기 : 아군총알
     *      -> 적군기 체력 감소. 아군 총알 dead
     *      
     * param 경우의수 
     * 1. 비행기 : 비행기
     *      -> 비행기 둘다 dead
     * 2. 총알 : 비행기
     *      -> 총알 dead. 비행기 체력 감소
     * @param unitArr plane 객체
     * @param opponentArr 상대편 객체
     */
    private void checkCollision(Unit unit, Plane[] opponentArr) {
        for (Plane opponent : opponentArr) {
            if (opponent == null) {
                return;
            }
            if (opponent.isDead()) {
                continue;
            }
            if (!opponent.isCheckCollision()) {
                continue;
            }

            boolean isCollision = opponent.isCollision(unit);
            if (isCollision) {
                unit.dead();
                if (unit instanceof Plane) {
                    opponent.dead();
                } else if (unit instanceof Bullet) {
                    opponent.setLife(-1);
                }
                System.out.println("collection | " + opponent.getClass().getName() + " | " + opponent.getLife());
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        tc.timeCheckerStart();

        BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = tempImg.createGraphics();
        g2d.drawImage(BACK_GROUND_IMG, 0, 0, width, height, 0, 0, BACK_GROUND_IMG.getWidth(), BACK_GROUND_IMG.getHeight(), null);

        drawUnit(g2d, friendlyArr);
        drawUnit(g2d, enemyArr);
        g.drawImage(tempImg, 0, 0, null);

        tc.timeCheckerEnd();
    }

    private void drawUnit(Graphics2D g2d, Unit unit) {
        if (unit.hasSubUnit()) {
            drawUnit(g2d, unit.getSubUnitArr());
        }
        unit.draw(g2d);
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
