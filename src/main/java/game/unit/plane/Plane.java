package game.unit.plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.Point;
import game.unit.Unit;
import game.unit.bullet.Bullet;
import game.unit.bullet.BulletFactory;

public abstract class Plane extends Unit {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract String[] getBulletNames();// TODO 나중엔 int로 바꾸는게 어떨까함 속도가 문제 된다면.

    private final Bullet[] bulletArr;
    private int bulletRateCount = 0;
    private int bulletArrIdx = 0;
    private int bulletLevel = 1;

    public Plane(Point pos, double direction) {
        super(pos, direction);
        bulletArr = new Bullet[UNIT_ARR_LENGTH];
        life = maxLife();
    }

    // life
    private int life;

    protected abstract int maxLife(); // 체력

    public boolean isCollision(Unit opponent) {
        int x1 = getX();
        int y1 = getY();
        int x2 = x1 + getWidth();
        int y2 = y1 + getHeight();

        int x1o = opponent.getX();
        int y1o = opponent.getY();
        int x2o = x1o + opponent.getWidth();
        int y2o = y1o + opponent.getHeight();

        boolean matchX = x1 <= x1o && x1o <= x2 || x1 <= x2o && x2o <= x2;// x1o가 x1과 x2 사이에 있거나 x2o가 x1과 x2 사이에 있는지
        boolean matchY = y1 <= y1o && y1o <= y2 || y1 <= y2o && y2o <= y2; // y1o가 y1과 y2 사이에 있거나 y2o가 y1과 y2 사이에 있는지
        if (matchX && matchY) { // 둘다 맞으면 해당 범위 안에 들어와있다고 판단
            return true; // TODO 차후 세부 충돌코드는 여기에 구현
        }
        return false;
    }

    @Override
    public Unit[] getSubUnitArr() {
        return bulletArr;
    }

    @Override
    public boolean isCheckCollision() {
        return true;
    }

    protected void shotBullet() {
        bulletRateCount++;
        try {
            String[] bulletNames = getBulletNames();
            for (String bulletName : bulletNames) {
                if (bulletRateCount % BulletFactory.getBulletRate(bulletName) == 0) {
                    try {
                        Unit[] unitArr = getSubUnitArr();
                        Bullet bullet = (Bullet) unitArr[bulletArrIdx];
                        if (bullet != null) {
                            // 총알이 나오는 위치
                            if (bullet.getClass().getSimpleName().equalsIgnoreCase(bulletName)) {
                                if (bullet.isDead()) {
                                    bullet.alive(getCenterPos(), bulletLevel);
                                    return;
                                } else {
                                    // 배열 크기 이상의 총알이 살아있다는 의미. 총알 배열 크기를 늘려줘야함
                                    logger.error("bullet still alive. didn't die. skip resurrection.");
                                }
                            }
                        }
                        unitArr[bulletArrIdx] = BulletFactory.getBullet(bulletName, getCenterPos(), bulletLevel);
                    } finally {
                        if (++bulletArrIdx >= UNIT_ARR_LENGTH) {
                            bulletArrIdx = 0;
                        }
                    }
                    // TODO 테스트용이므로 삭제해야함
                    bulletLevel++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int varianceValue) {
        life += varianceValue;
        if (life < 1) {
            this.kill();
        }
        if (life > maxLife()) {
            life = maxLife();
        }
    }

    public void setBulletLevel(int bulletLevel) {
        this.bulletLevel = bulletLevel;
    }
}
