package game.unit.plane.friendly.satellite;

import game.Point;
import game.unit.plane.friendly.Friendly;

public class SatelliteLeft extends Satellite {
    public SatelliteLeft(Point pos, Friendly friendly) {
        super(pos, friendly);
    }

    @Override
    protected int satellitePosition() {
        return -30;
    }
}
