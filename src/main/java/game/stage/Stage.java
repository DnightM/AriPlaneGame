package game.stage;

import game.unit.Unit;
import game.unit.bullet.Bullet;
import game.unit.plane.Plane;
import game.unit.plane.enemy.Enemy;
import game.unit.plane.friendly.Friendly;
import game.util.TimeChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public abstract class Stage extends JPanel {
    private static final Logger logger = LoggerFactory.getLogger(Stage.class);

    private static final int FRIENDLY_MAX_COUNT = 10;
    private static final int ENEMY_MAX_COUNT = 100;

    private final TimeChecker tc = new TimeChecker("drawer");

    private static BufferedImage BACK_GROUND_IMG;
    public static int WIDTH;
    public static int HEIGHT;
    protected Friendly[] friendlyArr;
    protected Enemy[] enemyArr;

    /**
     * 적기 등의 스테이지 시나리오 정의
     */
    public abstract void init();

    public Stage(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        this.friendlyArr = new Friendly[FRIENDLY_MAX_COUNT];
        this.enemyArr = new Enemy[ENEMY_MAX_COUNT];

        try {
            BACK_GROUND_IMG = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/background.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    public void run() {
        TimeChecker tc = new TimeChecker("worker");
        executor.scheduleAtFixedRate(() -> {
            tc.timeCheckerStart();

            move();

            tc.timeCheckerEnd();
        }, 0, 1000 / 120, TimeUnit.MILLISECONDS);
    }

    private void move() {
        try {
            if (!pause) {
                moveUnit(friendlyArr, enemyArr);
                moveUnit(enemyArr, friendlyArr);
                this.repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void moveUnit(Unit[] unitArr, Plane[] opponentArr) {
        for (Unit unit : unitArr) {
            if (unit == null) {
                break;
            }
            if (!unit.isDead()) {
                if (unit.isGuided()) {
                    Unit opponent = unit.getGuidedTarget(opponentArr);
                    unit.setGuidedTarget(opponent);
                }
                unit.move();
                checkCollision(unit, opponentArr); // 충돌검사
            }
            moveUnit(unit.getSubUnitArr(), opponentArr);
        }
    }

    /**
     * 경우의수3
     * 1. 아군기 : 적군기 , 적군기 : 아군기
     * -> 아군기 및 적군기 dead. 라이프 상관x
     * 2. 아군기 : 적군총알
     * -> 아군기 체력 감소. 적군 총알 dead
     * 3. 적군기 : 아군총알
     * -> 적군기 체력 감소. 아군 총알 dead
     * <p>
     * param 경우의수
     * 1. 비행기 : 비행기
     * -> 비행기 둘다 dead
     * 2. 총알 : 비행기
     * -> 총알 dead. 비행기 체력 감소
     *
     * @param unit        plane 객체, bullet 객체
     * @param opponentArr 상대편 객체
     */
    private void checkCollision(Unit unit, Plane[] opponentArr) {
        // TODO opponentArr이 미리 정렬되어있으면 더 효율적인 검사가 가능. 차후 변경 요망
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
                unit.kill();
                if (unit instanceof Plane) {
                    opponent.kill();
                } else if (unit instanceof Bullet) {
                    opponent.setLife(-1);
                }
                logger.info("collection | " + opponent.getClass().getName() + " | " + opponent.getLife());
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        tc.timeCheckerStart();

        BufferedImage tempImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = tempImg.createGraphics();
        g2d.drawImage(BACK_GROUND_IMG, 0, 0, WIDTH, HEIGHT, 0, 0, BACK_GROUND_IMG.getWidth(), BACK_GROUND_IMG.getHeight(), null);

        drawUnit(g2d, friendlyArr);
        drawUnit(g2d, enemyArr);
        g.drawImage(tempImg, 0, 0, null);

        tc.timeCheckerEnd();
    }

    private void drawUnit(Graphics2D g2d, Unit unit) {
        drawUnit(g2d, unit.getSubUnitArr());
        if (!unit.isDead()) {
            unit.draw(g2d);
        }
    }

    private void drawUnit(Graphics2D g2d, Unit[] unitArr) {
        for (Unit unit : unitArr) {
            if (unit == null) {
                continue;
            }
            drawUnit(g2d, unit);
        }
    }

    public KeyAdapter getKeyAdapter() {
        return friendlyArr[0].getKeyAdapter();
    }

    private boolean pause = false;

    public KeyAdapter getOptionKeyAdapter() {
        return new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    // pause
                    pause = !pause;
                }
            }
        };
    }
}
