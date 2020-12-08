package unit.bullet.guided;

public class GuidedRightBullet extends GuidedBullet {
    public GuidedRightBullet(int x, int y) {
        super(x + 10, y);
    }

    @Override
    public void alive(int x, int y) {
        super.alive(x + 10, y);
    }

    @Override
    protected int getWeight(int y) {
        return -(int) (Math.abs(y) / (acceleration * 2));
    }
}
