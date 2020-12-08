package game.unit.bullet.guided;

import game.Point;

public class GuidedLeftBullet extends GuidedBullet {
    public GuidedLeftBullet(Point pos) {
        super(new Point(pos.x - 10, pos.y));
    }

    @Override
    public void alive(Point pos) {
        super.alive(new Point(pos.x - 10, pos.y));
    }

    @Override
    protected int getWeight(int y) {
        return (int) (Math.abs(y) / (acceleration * 2));
    }
}
