package game.stage;

import game.Point;
import game.unit.plane.friendly.Friendly1;
import game.unit.plane.friendly.satellite.SatelliteLeft;
import game.unit.plane.friendly.satellite.SatelliteRight;

@SuppressWarnings("serial")
public class StageSingle extends Stage {
    public StageSingle(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        friendlyArr[0] = new Friendly1(new Point(500, 900));
        friendlyArr[1] = new SatelliteLeft(friendlyArr[0]);
        friendlyArr[2] = new SatelliteRight(friendlyArr[0]);

    }
}
