package game.stage;

import game.Point;
import game.unit.plane.friendly.*;
import game.unit.plane.friendly.satellite.*;

@SuppressWarnings("serial")
public class StageSingle extends Stage {
    public StageSingle(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new FriendlyGuided(new Point(WIDTH / 2 + Friendly.WIDTH / 2, HEIGHT -100));
        friendlyArr[0].setBulletLevel(1);
//        friendlyArr[1] = new SatelliteLeft(friendlyArr[0]);
//        friendlyArr[2] = new SatelliteRight(friendlyArr[0]);

    }
}
